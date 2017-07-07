package com.jing.executor;

import android.content.Context;
import android.view.MenuItem;

import com.jing.R;
import com.jing.activity.AboutMeActivity;
import com.jing.util.ToastUtils;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */
public class NaviMenuExecutor {

    public static boolean onNavigationItemSelected(MenuItem item, Context context) {
        switch (item.getItemId()) {
            case R.id.home:
//                initFragment(new HomeFragment());
               return true;
            case R.id.moments:
                ToastUtils.showToast("Moments");
                return true;
            case R.id.setting:
                ToastUtils.showToast("Settings");
                return true;
            case R.id.theme:
                ToastUtils.showToast("Themes");
                return true;
            case R.id.what:
                AboutMeActivity.launch(context);
                return true;
        }
        return false;
    }
}
