package com.jing.injector.module;

import com.jing.activity.base.IBasePresenter;
import com.jing.activity.splash.SplashActivity;
import com.jing.activity.splash.SplashPresenter;
import com.jing.injector.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */
@Module
public class SplashActivityModule {

    private final SplashActivity mSplash;

    public SplashActivityModule(SplashActivity view) {
        this.mSplash = view;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new SplashPresenter(mSplash);
    }
}
