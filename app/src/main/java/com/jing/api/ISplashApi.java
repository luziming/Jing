package com.jing.api;

import com.jing.entry.Splash;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

public interface ISplashApi {

    /**
     * Splash背景图
     * http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1
     */
    @GET("HPImageArchive.aspx")
    Observable<Splash> getSplash(@Query("format") String format,
                                 @Query("idx") String idx,
                                 @Query("n") String n);
}
