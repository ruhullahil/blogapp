package com.toru.blogapp.homefregment.models.model;

import com.google.gson.annotations.SerializedName;

public class author {
    @SerializedName("id")
    public String id;
    @SerializedName("displayName")
    public String displayName;
    @SerializedName("url")
    public  String url;
    @SerializedName("image")
    public _image image;


    public author(String id, String displayName, String url, _image image) {
        this.id = id;
        this.displayName = displayName;
        this.url = url;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public _image getImage() {
        return image;
    }

    public void setImage(_image image) {
        this.image = image;
    }
}
