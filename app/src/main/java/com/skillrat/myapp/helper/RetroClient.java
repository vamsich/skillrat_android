package com.skillrat.myapp.helper;

import com.skillrat.myapp.api.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abhi on 06 Sep 2017 006.
 */

public class RetroClient {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://private-2dbd17-skillpay.apiary-mock.com";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}