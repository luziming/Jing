package com.jing.injector.component;

import com.jing.activity.splash.SplashActivity;
import com.jing.injector.PerFragment;
import com.jing.injector.module.SplashActivityModule;

import dagger.Component;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = SplashActivityModule.class)
public interface SplashActivityComponent {
    void inject(SplashActivity splashActivity);
}
