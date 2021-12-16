package com.edu.neu.homework1.gson;

import com.google.gson.annotations.SerializedName;

/*
"now":{
    "cloud": "99",
    "cond_code": "101",
    "cond_txt": "多云",
    "fl": "16",
    "hum": "66",
    "pcpn": "0.0",
    "pres": "1014",
    "tmp": "17",
    "vis": "8",
    "wind_deg": "173",
    "wind_dir": "南风",
    "wind_sc": "2",
    "wind_spd": "8",
    "cond": {
        "code": "101",
        "txt": "多云"
    }
}
 */
public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More {
        @SerializedName("txt")
        public String info;

        //我感觉这里可以加上code，方面改变云朵的图片，再说吧
    }
}
