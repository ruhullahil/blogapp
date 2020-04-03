package com.toru.blogapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responceResult {
    @SerializedName("kind")
    public String kind;
    @SerializedName("nextPageToken")
    public String nextPageToken;
    @SerializedName("items")
    public List<itemes> Items;
    @SerializedName("etag")
    public String etag;

    public responceResult(String kind, String nextPageToken, List<itemes> items, String etag) {
        this.kind = kind;
        this.nextPageToken = nextPageToken;
        Items = items;
        this.etag = etag;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<itemes> getItems() {
        return Items;
    }

    public void setItems(List<itemes> items) {
        Items = items;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    @Override
    public String toString() {
        return "responceResult{" +
                "kind='" + kind + '\'' +
                ", nextPageToken='" + nextPageToken + '\'' +
                ", Items=" + Items +
                ", etag='" + etag + '\'' +
                '}';
    }
}
