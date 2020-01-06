package com.bawei.duanhaitao.util;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:27
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bawei.duanhaitao.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    public OkHttpClient okHttpClient;
    public Retrofit retrofit;
    public static RetrofitUtil instance = null;
    private RetrofitUtil (){
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                        okHttpClient = new OkHttpClient.Builder()
                                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                                .build()
                )
                .build();
    }
    public static synchronized RetrofitUtil getInstance(){
        if (instance==null){
            instance = new RetrofitUtil();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
    public boolean getNetUtil(Context context){
       ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }
}
