package com.example.repogithub.data.api;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL = "https://api.github.com/";
    public static final String USER = "alvaroCoelho";
    public static final String TOKEN = "2866008c8989db7d18907397ba27bdac389fffc6";
    public static Retrofit retrofit = null;
    public static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(  new OkHttpClient()
                            .newBuilder()
                            .addInterceptor(new BasicAuthInterceptor(USER, TOKEN))
                            .connectTimeout(60L, TimeUnit.SECONDS)
                            .readTimeout(60L, TimeUnit.SECONDS)
                            .build())
                    .build();
        }

        return retrofit;

    }


}
