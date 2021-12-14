package com.edu.neu.homework1.http;

import java.io.IOException;

public interface MyCallBack {

        void onFailure(IOException e);

        void onResponse(String response) throws IOException;
}
