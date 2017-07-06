package com.jing.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;

import com.jakewharton.rxbinding.view.RxView;
import com.jing.R;
import com.jing.activity.base.BaseActivity;

import butterknife.BindView;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/6.
 */

public class AboutMeActivity extends BaseActivity {


    @BindView(R.id.titleBar)
    Toolbar titleBar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    public static final String EMAIL_URI = "mailto:geniuskai92@gmail.com";

    public static void launch(Context context) {
        Intent intent = new Intent(context, AboutMeActivity.class);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.slide_right_entry, R.anim.hold);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_about_me;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initToolBar(titleBar,true,"关于作者");
        RxView.clicks(fab).subscribe(aVoid -> email2Me());
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    void email2Me() {
        Uri uri = Uri.parse(EMAIL_URI);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(intent);
    }
}
