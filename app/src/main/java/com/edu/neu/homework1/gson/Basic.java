package com.edu.neu.homework1.gson;

import com.google.gson.annotations.SerializedName;
/*
{
    "cid": "CN101120801",
    "location": "泰安",
    "parent_city": "泰安",
    "admin_area": "山东",
    "cnty": "中国",
    "lat": "38.91458893",
    "lon": "121.61862183",
    "tz": "+8.00",
    "city": "泰安",
    "id": "CN101120801",
    "update": {
        "loc": "2021-12-15 11:19",
        "utc": "2021-12-15 11:19"
    }
}
 */
public class Basic {
    //由于 JSON 中的一些字段可能不太适合直接作为 Java 字段来命名，因此这里使用了
    //@SerializedName 注解的方式来让 JSON 字段和 Java 字段之间建立映射关系。
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;
    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
