package com.example.mybilibili.https;

import android.util.Log;

import com.example.mybilibili.utils.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    public static void sendGET(String url, OnResponseListener onResponseListener) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("TAG", "onFailure: "+e.getMessage());
                ToastUtils.showToastShort("请求失败，请重新请求");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String string = response.body().string();
                onResponseListener.onResponse(string);
            }
        });
    }
    public interface OnResponseListener {
        void onResponse(String string);
    }
}
