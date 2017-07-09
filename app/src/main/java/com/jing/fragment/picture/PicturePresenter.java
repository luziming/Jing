package com.jing.fragment.picture;

import android.util.Log;

import com.jing.activity.base.IBasePresenter;
import com.jing.activity.base.ILoadDataView;
import com.jing.api.RetrofitService;
import com.jing.entry.JokeImgs;
import com.jing.util.ToastUtils;

import java.util.List;

import rx.Subscriber;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/8.
 */

public class PicturePresenter implements IBasePresenter{


    private final ILoadDataView<List<JokeImgs.Image>> mView;

    private int page = 1;

    public PicturePresenter(ILoadDataView view) {
        this.mView = view;
    }


    @Override
    public void getData(boolean isRefresh) {
        RetrofitService.getJokeImgs(page)
                .compose(mView.bindToLife())
                .subscribe(new Subscriber<JokeImgs>() {
                    @Override
                    public void onCompleted() {
                        if (isRefresh)
                            mView.finishRefresh();
                        else
                            mView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("HomePresenter", "onError:" + e.toString());
                        if (isRefresh)
                            mView.finishRefresh();
                        else
                            mView.showNetError();
                    }
                    @Override
                    public void onNext(JokeImgs jokes) {
                        if (jokes.getError_code() != 0) {
                            ToastUtils.showToast(jokes.getReason());
                            return;
                        }
                        List<JokeImgs.Image> data = jokes.getResult();
                        if (data == null || data.size() <= 0) {
                            ToastUtils.showToast("没有更多数据");
                            return;
                        }
                        mView.loadData(data);
                        page ++;
                    }
                });
    }

    @Override
    public void getMoreData() {
        RetrofitService.getJokeImgs(page)
                .compose(mView.bindToLife())
                .subscribe(new Subscriber<JokeImgs>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        mView.showNetError();
                    }
                    @Override
                    public void onNext(JokeImgs jokes) {
                        if (jokes.getError_code() != 0) {
                            ToastUtils.showToast(jokes.getReason());
                            return;
                        }
                        List<JokeImgs.Image> data = jokes.getResult();
                        if (data == null || data.size() <= 0) {
                            ToastUtils.showToast("没有更多数据");
                            return;
                        }
                        mView.loadMoreData(data);
                        page ++;
                    }
                });
    }
}
