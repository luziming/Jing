package com.jing.injector.module;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.activity.base.IBasePresenter;
import com.jing.adapter.HomeAdapter;
import com.jing.entry.Jokes;
import com.jing.fragment.home.HomeFragment;
import com.jing.fragment.home.HomePresenter;
import com.jing.injector.PerFragment;

import java.util.List;

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
    private List<Jokes.Joke> mList;

    public HomeFragmentModule(HomeFragment view, List<Jokes.Joke> mList) {
        this.mHomeView = view;
        this.mList = mList;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new HomePresenter(mHomeView);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new HomeAdapter(mList);
    }
}
