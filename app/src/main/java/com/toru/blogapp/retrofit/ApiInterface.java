package com.toru.blogapp.retrofit;

import com.toru.blogapp.model.responceResult;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("posts")
    Call<responceResult> getResult(
            @Query(value = "key") String key
    );
}
