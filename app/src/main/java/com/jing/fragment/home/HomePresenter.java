package com.jing.fragment.home;

import android.util.Log;

import com.jing.activity.base.IBasePresenter;
import com.jing.activity.base.ILoadDataView;
import com.jing.api.RetrofitService;
import com.jing.entry.Jokes;
import com.jing.util.ToastUtils;

import java.util.List;

import rx.Subscriber;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

public class HomePresenter implements IBasePresenter {

    private final ILoadDataView<List<Jokes.Joke>> mView;

    private int page = 1;

    public HomePresenter(ILoadDataView view) {
        this.mView = view;
    }

    @Override
    public void getData(boolean isRefresh) {
        RetrofitService.getJokes(page)
                .compose(mView.bindToLife())
                .subscribe(new Subscriber<Jokes>() {
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
                    public void onNext(Jokes jokes) {
                        if (jokes.getError_code() != 0) {
                            ToastUtils.showToast(jokes.getReason());
                            return;
                        }
                        List<Jokes.Joke> data = jokes.getResult();
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
        RetrofitService.getJokes(page)
                .compose(mView.bindToLife())
                .subscribe(new Subscriber<Jokes>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        mView.showNetError();
                    }
                    @Override
                    public void onNext(Jokes jokes) {
                        if (jokes.getError_code() != 0) {
                            ToastUtils.showToast(jokes.getReason());
                            return;
                        }
                        List<Jokes.Joke> data = jokes.getResult();
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
