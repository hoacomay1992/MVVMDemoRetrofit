package com.example.mvvm_demo_retrofit.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//volley_array.json"
public class RetrofitInstance {
    private static Retrofit retrofit;


    public static Retrofit getRetrofitClient(String Base_Url) {
        OkHttpClient builder = new OkHttpClient.Builder().build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder)
                    .build();
        }
        return retrofit;
    }
}
