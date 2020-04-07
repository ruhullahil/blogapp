package com.toru.blogapp;

import android.graphics.Bitmap;
import android.media.Image;

public class Post {
    private String title ;
    private String time ;
    private String image;
    private String PostUrl;

    public Post() {
    }

    public Post(String title, String time, String image, String postUrl) {
        this.title = title;
        this.time = time;
        this.image = image;
        PostUrl = postUrl;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPostUrl() {
        return PostUrl;
    }

    public void setPostUrl(String postUrl) {
        PostUrl = postUrl;
    }
}
