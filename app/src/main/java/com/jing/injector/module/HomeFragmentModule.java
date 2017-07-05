package com.jing.injector.module;

import com.jing.activity.base.IBasePresenter;
import com.jing.fragment.HomeFragment;
import com.jing.fragment.HomePresenter;
import com.jing.injector.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

@Module
public class HomeFragmentModule {

    private final HomeFragment mHomeView;

    public HomeFragmentModule(HomeFragment view) {
        this.mHomeView = view;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new HomePresenter(mHomeView);
    }
}
