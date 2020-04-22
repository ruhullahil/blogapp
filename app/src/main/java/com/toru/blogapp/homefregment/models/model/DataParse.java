package com.toru.blogapp.homefregment.models.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.toru.blogapp.homefregment.models.Post;
import com.toru.blogapp.homefregment.retrofit.ApiClient;
import com.toru.blogapp.homefregment.retrofit.ApiInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class DataParse {
    private String key = "AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM";
    final String TAG = "homefrgment";
    private ApiInterface apiInterface;
    private responceResult ResponceResult;


    private void InitialCall() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Log.i(TAG,"________________________INITIAL METHOD called ____________________");
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
        Log.i("TAG","__________Post Method call ______________--");
        InitialCall();
        for (itemes item: ResponceResult.Items) {
            post.setTitle(item.title);
            post.setTime(item.published);
            post.setPostUrl(item.url);
            //post.setImageUrl(imageGet(item.content));
            posts.add(post);
        }

        return posts;
    }
     private Bitmap getImageFromUrl(String imgUrl) throws IOException {

         URL url = new URL(imgUrl);
         Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
         return bmp;

     }
     private  String getImageString(String content)
     {

         String reg ="href=[\\'\"]?([^\\'\" >]+)";
         Pattern r = Pattern.compile(reg);

         // Now create matcher object.
         Matcher m = r.matcher(content);
         if (m.find( )) {
             //System.out.println("Found value: " + m.group(0) );
             return m.group(1);

         }
         return null;


     }
     private Bitmap imageGet(String content)
     {
         String url = getImageString(content);
         if(url!=null)
         {
             try {
                 return getImageFromUrl(url);
             } catch (IOException e) {
                 Log.i("theow ",e.getMessage());
             }
         }
         return null;

     }


}
