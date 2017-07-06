package com.jing.activity;

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
import com.jing.fragment.main.MainFragment;
import com.jing.util.ToastUtils;

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
        switch (item.getItemId()) {
            case R.id.home:
//                initFragment(new HomeFragment());
                break;
            case R.id.moments:
                ToastUtils.showToast("Moments");
                break;
            case R.id.setting:
                ToastUtils.showToast("Settings");
                break;
            case R.id.theme:
                ToastUtils.showToast("Themes");
                break;
            case R.id.what:
                AboutMeActivity.launch(MainActivity.this);
                break;
        }
        return true;
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
