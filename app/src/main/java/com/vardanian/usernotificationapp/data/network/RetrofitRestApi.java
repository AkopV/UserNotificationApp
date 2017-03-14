package com.vardanian.usernotificationapp.data.network;

import com.vardanian.usernotificationapp.model.UserData;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface RetrofitRestApi {

    @GET("/api/")
        Observable<UserData> getUsers();
}
