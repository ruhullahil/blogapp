package com.toru.blogapp.retrofit;

import com.toru.blogapp.model.responceResult;

import retrofit.http.GET;
import retrofit2.Call;

public interface ApiInterface {
    @GET("/posts?key=AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM")
    Call<responceResult> getResult();
}
