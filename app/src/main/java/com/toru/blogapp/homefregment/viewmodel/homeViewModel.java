package com.toru.blogapp.homefregment.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.toru.blogapp.homefregment.models.model.itemes;
import com.toru.blogapp.homefregment.models.model.responceResult;
import com.toru.blogapp.homefregment.retrofit.postReposetory;

public class homeViewModel extends ViewModel {
    private MutableLiveData<responceResult> mutableLiveData;
    private postReposetory postrepo;
    private String key = "AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM";

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        postrepo = postReposetory.getInstance();
        mutableLiveData = postrepo.getResult(key);

    }

    public LiveData<responceResult> getPostRepository() {
        return mutableLiveData;
    }
}

