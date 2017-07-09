package com.jing.injector.component;

import com.jing.fragment.picture.PictureFragment;
import com.jing.injector.PerFragment;
import com.jing.injector.module.PictureFragmentModule;

import dagger.Component;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/8.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = PictureFragmentModule.class)
public interface PictureFragmentConponent {
    void inject(PictureFragment fragment);
}
