package com.jing.activity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jing.R;
import com.jing.activity.base.BaseActivity;
import com.jing.activity.base.BaseFragment;
import com.jing.adapter.ViewPagerAdapter;
import com.jing.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.dl_left)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigation_view;
    @BindView(R.id.ll_left)
    LinearLayout ll_left;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.mAppBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.mViewpager)
    ViewPager mViewpager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.activity_main)
    FrameLayout activityMain;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initToolBar(toolbar, true, "鲸");
        setBackEnable();
        setOnRightMenuClick();

        mViewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(mViewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    protected void elseView() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //将侧边栏顶部延伸至status bar
            mDrawerLayout.setFitsSystemWindows(true);
            //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
            mDrawerLayout.setClipToPadding(false);
        }
    }


    private void setOnRightMenuClick() {
        /**设置MenuItem的字体颜色**/
        Resources resource = (Resources) getBaseContext().getResources();
        ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.text_default);
        navigation_view.setItemTextColor(csl);
        /**设置MenuItem默认选中项**/
        navigation_view.getMenu().getItem(0).setChecked(true);
        //初始化
        initFragment(new HomeFragment());

        navigation_view.setNavigationItemSelectedListener(item -> {
            BaseFragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.face:
                    break;
                case R.id.car:
                    break;
                case R.id.setting:
                    break;
                case R.id.what:
                    break;
            }
//            if (fragment != null) {
//                initFragment(fragment);
//            }
            item.setChecked(true);
            mDrawerLayout.closeDrawer(ll_left);
            return true;
        });
    }


    private void initFragment(BaseFragment fragment) {
//        getSupportFragmentManager()
//                .beginTransaction().
//                replace(R.id.fl_container, fragment).commit();
    }

    public void setBackEnable() {
        //创建返回键，并实现打开关/闭监听
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
