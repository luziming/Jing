package com.jing.activity.splash;

import com.jing.activity.base.IBaseView;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

public interface ISplashView extends IBaseView{

    void loadImage(String url);

    void countDown(Integer num);

    void complete();
}
