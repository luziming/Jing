package com.jing.injector.component;

import com.jing.fragment.HomeFragment;
import com.jing.injector.PerFragment;
import com.jing.injector.module.HomeFragmentModule;

import dagger.Component;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = HomeFragmentModule.class)
public interface HomeFragmentComponent  {
    void inject(HomeFragment fragment);
}
