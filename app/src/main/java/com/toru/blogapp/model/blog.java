package com.toru.blogapp.model;

import com.google.gson.annotations.SerializedName;

public class blog {
    @SerializedName("id")
    public String id;

    public blog(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
