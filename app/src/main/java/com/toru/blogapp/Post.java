package com.toru.blogapp;

import android.graphics.Bitmap;
import android.media.Image;

public class Post {
    private String title ;
    private String time ;
    private Bitmap image;
    private String PostUrl;

    public Post(String title, String time, Bitmap image, String postUrl) {
        this.title = title;
        this.time = time;
        this.image = image;
        this.PostUrl = postUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Bitmap getImageUrl() {
        return image;
    }

    public void setImageUrl(Bitmap image) {
        this.image= image;
    }

    public String getPostUrl() {
        return PostUrl;
    }

    public void setPostUrl(String postUrl) {
        PostUrl = postUrl;
    }
}
