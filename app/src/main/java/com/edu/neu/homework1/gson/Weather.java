package com.edu.neu.homework1.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 总的实例类来引用刚刚创建的各个实体类
 */
public class Weather {
    //成功返回 ok，失败则会返回具体的原因
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
