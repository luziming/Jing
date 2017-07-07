package com.jing.fragment.main;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.jing.R;
import com.jing.activity.base.BaseFragment;
import com.jing.adapter.ViewPagerAdapter;
import com.melnykov.fab.FloatingActionButton;

import butterknife.BindView;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/6.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.mAppBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.mViewpager)
    ViewPager mViewpager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected int attachLayoutRes() {
        return R.layout.layout_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initToolBar(toolbar, true, getString(R.string.app_name));
        setHasOptionsMenu(true);
        mViewpager.setAdapter(new ViewPagerAdapter(mContext.getSupportFragmentManager(),fab,coordinatorLayout));
        tabLayout.setupWithViewPager(mViewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
