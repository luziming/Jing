package com.jing.fragment;

import com.jing.activity.base.IBasePresenter;
import com.jing.activity.base.ILoadDataView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

public class HomePresenter implements IBasePresenter {

    //模拟数据
    private ArrayList<Integer> list = new ArrayList<Integer>() {
        {
            for (int i = 0; i < 100; i++) {
                add(new Random().nextInt());
            }
        }
    };

    private final ILoadDataView<List<Integer>> mView;

    public HomePresenter(ILoadDataView view) {
        this.mView = view;
    }

    @Override
    public void getData(boolean isRefresh) {
        if (isRefresh) {
            Observable.interval(2, TimeUnit.SECONDS)
                    .compose(mView.bindToLife())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> mView.finishRefresh());
        } else {
            mView.loadData(list);
            mView.hideLoading();
        }
    }

    @Override
    public void getMoreData() {

    }
}
