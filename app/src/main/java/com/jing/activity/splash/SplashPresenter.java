package com.jing.activity.splash;

import android.text.TextUtils;
import android.util.Log;

import com.jing.activity.base.IBasePresenter;
import com.jing.api.RetrofitService;
import com.jing.util.RxHelper;

import java.util.Locale;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

public class SplashPresenter implements IBasePresenter {


    private static final String URL = "http://cn.bing.com%s_720x1280.jpg";

    private final ISplashView mView;


    public SplashPresenter(ISplashView view) {
        mView = view;
    }

    @Override
    public void getData(boolean isRefresh) {
        RetrofitService.getNewsList()
                .flatMap(splash -> {
                    String urlbase = splash.getImages().get(0).getUrlbase();
                    if (!TextUtils.isEmpty(urlbase)) {
                        mView.loadImage(String.format(Locale.getDefault(), URL, urlbase));
                    }
                    return RxHelper.countdown(4);
                })
                //绑定生命周期,防止内存泄漏
                .compose(mView.bindToLife())
                //订阅分别对应onNext,onError,onComplete,结合了Lambda
                .subscribe(mView::countDown
                        , throwable -> Log.e("SplashPresenter", "call:" + throwable.toString()),
                        mView::complete);
    }

    @Override
    public void getMoreData() {

    }
}
