package com.toru.blogapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.toru.blogapp.model.itemes;
import com.toru.blogapp.model.responceResult;
import com.toru.blogapp.retrofit.ApiClient;
import com.toru.blogapp.retrofit.ApiInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class DataParse {
    private String key = "AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM";
    final String TAG = "homefrgment";
    private ApiInterface apiInterface;
    private responceResult ResponceResult;


    DataParse() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<responceResult> call = apiInterface.getResult("AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM");
        call.enqueue(new Callback<responceResult>() {


            @Override
            public void onResponse(Call<responceResult> call, Response<responceResult> response) {
                Log.i(TAG,"______________________come to responce section ______________________________");
                Log.i(TAG,response.isSuccessful() ? "TRUE":"FALSE");
                if (response.isSuccessful()) {
                    Log.i(TAG,"___________________come to responce seccessfull");
                    if(response.body()!=null) {
                        Log.i(TAG,"go to responce body____________________");
                        ResponceResult = response.body();
                        Log.i(TAG,"_______________"+ResponceResult.kind);
//                        for(itemes item : ResponceResult.Items) {
//                            Log.i(TAG,item.title);
//                            Log.i(TAG,item.getContent());
//                        }
                    }

                }
                else {
                    Log.i(TAG, "_______________NOT WORKING ______________________________________");
                    //textView.setText(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<responceResult> call, Throwable t) {
                Log.i(TAG,"_____________________failer _______________________________________");
                //textView.setText(t.toString());

            }
        });
    }

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        Post post = null;
        for (itemes item: ResponceResult.Items) {
            post.setTitle(item.title);
            post.setTime(item.published);
            post.setPostUrl(item.url);


        }

        return posts;
    }
     private Bitmap getImage(String imgUrl) throws IOException {

         URL url = new URL(imgUrl);
         Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
         return bmp;

     }
//     private  String getImageString(String content)
//     {
//
//     }

}
