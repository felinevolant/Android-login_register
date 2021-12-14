package com.edu.neu.homework1.util;


import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    /**
     * 发起一条http请求调用这个方法
     * @param address 请求地址
     * @param callback 注册一个回调处理服务器响应
     */
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
    }

