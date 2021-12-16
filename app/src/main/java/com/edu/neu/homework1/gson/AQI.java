package com.edu.neu.homework1.gson;
/*
{
    "city": {
        "aqi": "36",
        "pm25": "18",
        "qlty": "优"
    }
}

原版的
"aqi":{
 "city":{
 "aqi":"44",
 "pm25":"13"
 }
}


 */
public class AQI {
    public AQICity city;
    public class AQICity {
        public String aqi;
        public String pm25;
        //新加上的空气质量
        public String qlty;
    }
}
