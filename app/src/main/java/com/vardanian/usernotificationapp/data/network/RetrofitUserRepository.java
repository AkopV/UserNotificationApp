package com.vardanian.usernotificationapp.data.network;

import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.UserData;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class RetrofitUserRepository implements MVPUserDataManager.UserDataModel {

    private RetrofitRestApi rest;

    public RetrofitUserRepository() {

        String API_BASE_URL = "https://randomuser.me";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();

        rest = retrofit.create(RetrofitRestApi.class);
    }

    @Override
    public Observable<UserData> fetchUsers() {
        return rest.getUsers();
    }
}
