package com.jing.activity;

import android.Manifest;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.jing.R;
import com.jing.activity.base.BaseActivity;
import com.jing.activity.base.BaseFragment;
import com.jing.executor.NaviMenuExecutor;
import com.jing.executor.WeatherExecutor;
import com.jing.fragment.main.MainFragment;
import com.jing.util.ToastUtils;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.dl_left)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigation_view;
    @BindView(R.id.ll_left)
    LinearLayout ll_left;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initDrawerLayout();
        updataWeather();
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    protected void elseView() {
        //将侧边栏顶部延伸至status bar
        mDrawerLayout.setFitsSystemWindows(true);
        //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
        mDrawerLayout.setClipToPadding(false);
    }

    private void initDrawerLayout() {
        /**设置MenuItem的字体颜色**/
        ColorStateList csl = getBaseContext().getResources().getColorStateList(R.color.text_default);
        navigation_view.setItemTextColor(csl);
        /**设置MenuItem默认选中项**/
        navigation_view.getMenu().getItem(0).setChecked(true);
        //初始化
        initFragment(new MainFragment());
        navigation_view.setNavigationItemSelectedListener(this);
    }

    private void updataWeather() {
        RxPermissions.getInstance(this).request(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe(granted -> {
                    if (granted)
                        new WeatherExecutor(navigation_view).execute();
                    else
                        ToastUtils.showToast(getString(R.string.no_permission, "位置信息", "更新天气"));
                });
    }
    private void initFragment(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction().
                replace(R.id.fl_main, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        if (item.isChecked()) {
            return true;
        }
        return NaviMenuExecutor.onNavigationItemSelected(item,this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
