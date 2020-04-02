package com.toru.blogapp.model;

import com.google.gson.annotations.SerializedName;

public class replies {
    @SerializedName("totalItems")
    public int totalItems;
    @SerializedName("selfLink")
    public String selfLink;

    public replies(int totalItems, String selfLink) {
        this.totalItems = totalItems;
        this.selfLink = selfLink;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }
}
