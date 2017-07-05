package com.jing.injector.module;

import android.content.Context;

import com.jing.global.AndroidApplication;
import com.jing.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/19.
 * Application Module
 */
@Module
public class ApplicationModule {

    private final AndroidApplication mApplication;
    private final RxBus mRxBus;

    public ApplicationModule(AndroidApplication application, RxBus rxBus) {
        mApplication = application;
        mRxBus = rxBus;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return mRxBus;
    }

}
