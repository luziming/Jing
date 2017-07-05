package com.jing.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.jing.api.RetrofitService;
import com.jing.injector.component.ApplicationComponent;
import com.jing.injector.component.DaggerApplicationComponent;
import com.jing.injector.module.ApplicationModule;
import com.jing.rxbus.RxBus;
import com.squareup.leakcanary.LeakCanary;

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
public class AndroidApplication extends Application {

    public static Handler mHandler = new Handler();
    private static ApplicationComponent mAppComponent;
    public static Context context;
    private RxBus mRxBus = new RxBus();
    @Override
    public void onCreate() {
        super.onCreate();
        if (context == null) {
            context = this;
        }
        initInjector();
        initConfig();
    }

    /**
     * 初始化注入器
     */
    private void initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, mRxBus))
                .build();
    }

    private void initConfig() {
        //检测内存泄漏
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        RetrofitService.init();
    }

    public static ApplicationComponent getAppComponent() {
        return mAppComponent;
    }

    public static Context getContext() {
        return context;
    }
}
