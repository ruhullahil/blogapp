package com.toru.blogapp.homefregment.retrofit;

import androidx.lifecycle.MutableLiveData;

import com.toru.blogapp.homefregment.models.Post;
import com.toru.blogapp.homefregment.models.model.itemes;
import com.toru.blogapp.homefregment.models.model.responceResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class postReposetory {
    private static postReposetory postrepo;

    public static postReposetory getInstance() {
        if (postrepo == null) {
            postrepo = new postReposetory();
        }
        return postrepo;

    }

    private ApiInterface apiInterface;

    public postReposetory() {
        this.apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }


    public MutableLiveData<responceResult> getResult( String key){
        final MutableLiveData<responceResult> newsData = new MutableLiveData<>();
        apiInterface.getResult(key).enqueue(new Callback<responceResult>() {
            @Override
            public void onResponse(Call<responceResult> call,
                                   Response<responceResult> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<responceResult> call, Throwable t) {

            }


        });
        return newsData;
    }
}
