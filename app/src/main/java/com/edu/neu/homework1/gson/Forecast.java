package com.edu.neu.homework1.gson;
/*
[
    {
        "date": "2021-12-16",
        "cond": {
            "txt_d": "多云"
        },
        "tmp": {
            "max": "20",
            "min": "12"
        }
    },
    {
        "date": "2021-12-17",
        "cond": {
            "txt_d": "晴"
        },
        "tmp": {
            "max": "19",
            "min": "9"
        }
    },
    {
        "date": "2021-12-18",
        "cond": {
            "txt_d": "多云"
        },
        "tmp": {
            "max": "15",
            "min": "7"
        }
    },
    {
        "date": "2021-12-19",
        "cond": {
            "txt_d": "晴"
        },
        "tmp": {
            "max": "22",
            "min": "15"
        }
    },
    {
        "date": "2021-12-20",
        "cond": {
            "txt_d": "晴"
        },
        "tmp": {
            "max": "20",
            "min": "9"
        }
    },
    {
        "date": "2021-12-21",
        "cond": {
            "txt_d": "小雨"
        },
        "tmp": {
            "max": "21",
            "min": "10"
        }
    }
]
 */

import com.google.gson.annotations.SerializedName;

/**
 * 多天搞成一个数组，这个类只代表一天的
 */
public class Forecast {
    public String date;
    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("cond")
    public More more;
    public class Temperature {
        public String max;
        public String min;
    }
    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
