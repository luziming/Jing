package com.jing.api;

import com.jing.entry.Jokes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/7.
 */

public interface IJuheApi {

    /**
     * 获取笑话
     */
    @GET("Joke/NewstJoke")
    Observable<Jokes> getJokes(@Query("key") String key,@Query("page") int page);
}
