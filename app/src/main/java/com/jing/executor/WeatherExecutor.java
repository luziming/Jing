package com.jing.executor;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocalWeatherForecast;
import com.amap.api.location.AMapLocalWeatherListener;
import com.amap.api.location.AMapLocalWeatherLive;
import com.amap.api.location.LocationManagerProxy;
import com.jing.R;
import com.jing.global.AndroidApplication;

import java.util.Calendar;


/**
 * <p>
 * 天气现象表
 * <p>
 * 晴
 * 多云
 * 阴
 * 阵雨
 * 雷阵雨
 * 雷阵雨并伴有冰雹
 * 雨夹雪
 * 小雨
 * 中雨
 * 大雨
 * 暴雨
 * 大暴雨
 * 特大暴雨
 * 阵雪
 * 小雪
 * 中雪
 * 大雪
 * 暴雪
 * 雾
 * 冻雨
 * 沙尘暴
 * 小雨-中雨
 * 中雨-大雨
 * 大雨-暴雨
 * 暴雨-大暴雨
 * 大暴雨-特大暴雨
 * 小雪-中雪
 * 中雪-大雪
 * 大雪-暴雪
 * 浮尘
 * 扬沙
 * 强沙尘暴
 * 飑
 * 龙卷风
 * 弱高吹雪
 * 轻霾
 * 霾
 */
public class WeatherExecutor implements IExecutor, AMapLocalWeatherListener {


    private static final String TAG = "WeatherExecutor";
    private Context mContext;

    private LinearLayout llWeather;
    private ImageView ivIcon;
    private TextView tvTemp;
    private TextView tvCity;
    private TextView tvWind;

    public WeatherExecutor(NavigationView navigationHeader) {
        mContext = AndroidApplication.getContext();
        View headerView = navigationHeader.getHeaderView(0);
        llWeather = (LinearLayout) headerView.findViewById(R.id.ll_weather);
        ivIcon = (ImageView) headerView.findViewById(R.id.iv_weather_icon);
        tvTemp = (TextView) headerView.findViewById(R.id.tv_weather_temp);
        tvCity = (TextView) headerView.findViewById(R.id.tv_weather_city);
        tvWind = (TextView) headerView.findViewById(R.id.tv_weather_wind);
    }

    @Override
    public void execute() {
        LocationManagerProxy mLocationManagerProxy = LocationManagerProxy.getInstance(AndroidApplication.getContext());
        mLocationManagerProxy.requestWeatherUpdates(LocationManagerProxy.WEATHER_TYPE_LIVE, this);
    }

    @Override
    public void onWeatherLiveSearched(AMapLocalWeatherLive aMapLocalWeatherLive) {
        if (aMapLocalWeatherLive != null && aMapLocalWeatherLive.getAMapException().getErrorCode() == 0) {
            updateView(aMapLocalWeatherLive);
        } else {
            Log.e(TAG, "获取天气预报失败,错误码:" + aMapLocalWeatherLive.getAMapException().getErrorCode());
        }
        release();
    }

    @Override
    public void onWeatherForecaseSearched(AMapLocalWeatherForecast aMapLocalWeatherForecast) {
    }

    private void updateView(AMapLocalWeatherLive aMapLocalWeatherLive) {
        try {
            llWeather.setVisibility(View.VISIBLE);
            ivIcon.setImageResource(getWeatherIcon(aMapLocalWeatherLive.getWeather()));
            tvTemp.setText(mContext.getString(R.string.weather_temp, aMapLocalWeatherLive.getTemperature()));
            tvCity.setText(aMapLocalWeatherLive.getCity());
            tvWind.setText(mContext.getString(R.string.weather_wind, aMapLocalWeatherLive.getWindDir(),
                    aMapLocalWeatherLive.getWindPower(), aMapLocalWeatherLive.getHumidity()));
        } catch (Exception e) {
            Log.e("WeatherExecutor", "updateView:" + e.toString());
        }

    }

    private int getWeatherIcon(String weather) {
        if (TextUtils.isEmpty(weather)) {
            return R.drawable.ic_weather_sunny;
        }

        if (weather.contains("-")) {
            weather = weather.substring(0, weather.indexOf("-"));
        }
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int resId;
        if (weather.contains("晴")) {
            if (hour >= 7 && hour < 19) {
                resId = R.drawable.ic_weather_sunny;
            } else {
                resId = R.drawable.ic_weather_sunny_night;
            }
        } else if (weather.contains("多云")) {
            if (hour >= 7 && hour < 19) {
                resId = R.drawable.ic_weather_cloudy;
            } else {
                resId = R.drawable.ic_weather_cloudy_night;
            }
        } else if (weather.contains("阴")) {
            resId = R.drawable.ic_weather_overcast;
        } else if (weather.contains("雷阵雨")) {
            resId = R.drawable.ic_weather_thunderstorm;
        } else if (weather.contains("雨夹雪")) {
            resId = R.drawable.ic_weather_sleet;
        } else if (weather.contains("雨")) {
            resId = R.drawable.ic_weather_rain;
        } else if (weather.contains("雪")) {
            resId = R.drawable.ic_weather_snow;
        } else if (weather.contains("雾") || weather.contains("霾")) {
            resId = R.drawable.ic_weather_foggy;
        } else if (weather.contains("风") || weather.contains("飑")) {
            resId = R.drawable.ic_weather_typhoon;
        } else if (weather.contains("沙") || weather.contains("尘")) {
            resId = R.drawable.ic_weather_sandstorm;
        } else {
            resId = R.drawable.ic_weather_cloudy;
        }
        return resId;
    }

    private void release() {
        mContext = null;
        llWeather = null;
        ivIcon = null;
        tvTemp = null;
        tvCity = null;
        tvWind = null;
    }

    @Override
    public void onPrepare() {
    }

    @Override
    public void onExecuteSuccess(Object o) {
    }

    @Override
    public void onExecuteFail(Exception e) {
    }
}
