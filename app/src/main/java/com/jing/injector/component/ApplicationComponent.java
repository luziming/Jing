package com.jing.injector.component;

import android.content.Context;

import com.jing.injector.module.ApplicationModule;
import com.jing.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by long on 2016/8/19.
 * Application Component
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(BaseActivity baseActivity);
//     provide
    Context getContext();
    RxBus getRxBus();
}
