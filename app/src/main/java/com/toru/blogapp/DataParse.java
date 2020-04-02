package com.toru.blogapp;

import java.util.ArrayList;
import java.util.List;

public class DataParse {
private String id = "1748227958837492655";
private  String key = "AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM";
private  String postsUrl="https://www.googleapis.com/blogger/v3/blogs/"+id+"/posts?key="+key;
private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {


        return posts;
    }
}
