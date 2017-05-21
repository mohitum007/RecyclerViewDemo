package com.mohitum.recyclerviewdemo.api;

import com.mohitum.recyclerviewdemo.models.UsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiInterface {

    @GET(AppUrls.DEMO_GET_API)
    Call<UsersResponse> getDemoUsers(@Query("page") String page);
}
