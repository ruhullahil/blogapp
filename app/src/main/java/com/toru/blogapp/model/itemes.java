package com.toru.blogapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class itemes {
    @SerializedName("kind")
    public String kind;
    @SerializedName("id")
    public String id;
    @SerializedName("blog")
    public blog Blog;
    @SerializedName("published")
    public String published;
    @SerializedName("updated")
    public String updated;
    @SerializedName("url")
    public String url;
    @SerializedName("selfLink")
    public String selfLink;
    @SerializedName("title")
    public String title;
    @SerializedName("titleLink")
    public String titleLink;
    @SerializedName("content")
    public String content;
    @SerializedName("author")
    public author Author;
    @SerializedName("replies")
    public replies Replies;
    @SerializedName("labels")
    public List<String>labels;
    @SerializedName("location")
    public Location location;
    @SerializedName("etag")
    public String etag;

    public itemes(String kind, String id, blog blog, String published, String updated, String url, String selfLink, String title, String titleLink, String content, author author, replies replies, List<String> labels, Location location, String etag) {
        this.kind = kind;
        this.id = id;
        Blog = blog;
        this.published = published;
        this.updated = updated;
        this.url = url;
        this.selfLink = selfLink;
        this.title = title;
        this.titleLink = titleLink;
        this.content = content;
        Author = author;
        Replies = replies;
        this.labels = labels;
        this.location = location;
        this.etag = etag;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public blog getBlog() {
        return Blog;
    }

    public void setBlog(blog blog) {
        Blog = blog;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public author getAuthor() {
        return Author;
    }

    public void setAuthor(author author) {
        Author = author;
    }

    public replies getReplies() {
        return Replies;
    }

    public void setReplies(replies replies) {
        Replies = replies;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
