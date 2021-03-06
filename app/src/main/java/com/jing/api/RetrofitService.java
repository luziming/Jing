package com.jing.api;

import com.jing.entry.JokeImgs;
import com.jing.entry.Jokes;
import com.jing.entry.Splash;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

public class RetrofitService {

    /**
     * Base地址
     */
    private static final String BASE_URL_SPLASH = "http://cn.bing.com/";
    private static final String BASE_URL_JUHE = "http://api.avatardata.cn/";
    /**
     * Api接口
     */
    private static ISplashApi mSplashApi;
    private static IJuheApi mJuheApi;

    private RetrofitService() {
        throw new AssertionError();
    }

    /**
     * 初始化网络通信服务
     */
    public static void init() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL_SPLASH)
                .build();
        mSplashApi = retrofit.create(ISplashApi.class);

        Retrofit juheRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL_JUHE)
                .build();
        mJuheApi = juheRetrofit.create(IJuheApi.class);

    }



    /*****************************************API******************************************/

    /**
     * 获取Splash背景图
     * @return
     */
    public static Observable<Splash> getNewsList() {
        return mSplashApi.getSplash("js","0","1")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取笑话
     * @param page 页数,默认1
     * @return
     */
    public static Observable<Jokes> getJokes(int page) {
        //申请的key
        String juheKey = "c985e8317b9446fbbc9b3515b4bbd177";
        return mJuheApi.getJokes(juheKey,page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取笑话
     * @param page 页数,默认1
     * @return
     */
    public static Observable<JokeImgs> getJokeImgs(int page) {
        String juheKey = "c985e8317b9446fbbc9b3515b4bbd177";
        //单页加载数量,默认20,最大50
        int rows = 15;
        return mJuheApi.getJokeImgs(juheKey,rows,page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
