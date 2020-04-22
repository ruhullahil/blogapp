package com.toru.blogapp.homefregment.retrofit;

import com.toru.blogapp.homefregment.models.model.responceResult;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("posts")
    Call<responceResult> getResult(
            @Query(value = "key") String key
    );
}
