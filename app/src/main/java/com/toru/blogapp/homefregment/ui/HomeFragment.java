package com.toru.blogapp.homefregment.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toru.blogapp.R;
import com.toru.blogapp.homefregment.models.Post;
import com.toru.blogapp.homefregment.models.handler.RecycleViewAdapter;
import com.toru.blogapp.homefregment.models.model.DataParse;
import com.toru.blogapp.homefregment.models.model.itemes;
import com.toru.blogapp.homefregment.models.model.responceResult;
import com.toru.blogapp.homefregment.retrofit.ApiClient;
import com.toru.blogapp.homefregment.retrofit.ApiInterface;
import com.toru.blogapp.homefregment.viewmodel.homeViewModel;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    private static final String ARG_PARAM1 = "";
    private static final String ARG_PARAM2 = "";
    RecyclerView recyclerView ;
    homeViewModel hviewModel;
    RecycleViewAdapter newsAdapter;
    ArrayList<itemes> articleArrayList = new ArrayList<>();



    public HomeFragment() {
        // Required empty public constructor
    }












    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        hviewModel = ViewModelProviders.of(getActivity()).get(homeViewModel.class);
        hviewModel.init();
        hviewModel.getPostRepository().observe(this, new Observer<responceResult>() {
            @Override
            public void onChanged(responceResult newsResponse) {
                List<itemes> newsArticles = newsResponse.Items;
                articleArrayList.addAll(newsArticles);
                newsAdapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.home_recyctleView);
        setupRecyclerView();



        return view;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    private void setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = new RecycleViewAdapter(getActivity(), articleArrayList);
            recyclerView .setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView .setAdapter(newsAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView .setNestedScrollingEnabled(true);
        } else {
            newsAdapter.notifyDataSetChanged();
        }
    }


}
