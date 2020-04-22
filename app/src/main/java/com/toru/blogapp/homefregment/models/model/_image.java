package com.toru.blogapp.homefregment.models.model;

import com.google.gson.annotations.SerializedName;

class _image {
    @SerializedName("url")
    public String url;

    public _image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
