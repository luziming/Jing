package com.jing.activity.splash;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.view.RxView;
import com.jing.R;
import com.jing.activity.MainActivity;
import com.jing.activity.base.BaseActivity;
import com.jing.activity.base.IBasePresenter;
import com.jing.injector.component.DaggerSplashActivityComponent;
import com.jing.injector.module.SplashActivityModule;
import com.jing.view.SimpleButton;

import java.util.Calendar;

import butterknife.BindView;

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/
public class SplashActivity extends BaseActivity<IBasePresenter> implements ISplashView{

    @BindView(R.id.iv_splash)
    ImageView iv_splash;
    @BindView(R.id.sb_skip)
    SimpleButton simpleButton;
    @BindView(R.id.tv_copyright)
    TextView tv_copyright;

    private boolean mIsSkip = false;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initInjector() {
        DaggerSplashActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .splashActivityModule(new SplashActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        tv_copyright.setText(getString(R.string.copyright, year));
        RxView.clicks(simpleButton).compose(this.bindToLife())
                .subscribe(aVoid -> doSkip());
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadImage(String url) {
        Glide.with(this).load(url).asBitmap().into(iv_splash);
    }

    @Override
    public void countDown(Integer num) {
        simpleButton.setText("跳过 " + num);
    }

    @Override
    public void complete() {
        doSkip();
    }

    private void doSkip() {
        if (!mIsSkip) {
            mIsSkip = true;
            finish();
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
        }
    }
    @Override
    public void onBackPressed() {
        // 不响应后退键
        return;
    }
}
