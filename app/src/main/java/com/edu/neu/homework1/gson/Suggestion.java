package com.edu.neu.homework1.gson;

import com.google.gson.annotations.SerializedName;

/*
{
    "comf": {
        "type": "comf",
        "brf": "舒适",
        "txt": "白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"
    },
    "sport": {
        "type": "sport",
        "brf": "较适宜",
        "txt": "天气较好，较适宜进行各种运动，但因湿度偏高，请适当降低运动强度。"
    },
    "cw": {
        "type": "cw",
        "brf": "较适宜",
        "txt": "较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"
    }
}
 */
public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort;
    @SerializedName("cw")
    public CarWash carWash;
    public Sport sport;
    public class Comfort {
        @SerializedName("txt")
        public String info;
    }
    public class CarWash {
        @SerializedName("txt")
        public String info;
    }
    public class Sport {
        @SerializedName("txt")
        public String info;
    }
}
