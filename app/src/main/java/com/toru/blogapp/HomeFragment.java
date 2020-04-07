package com.toru.blogapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.toru.blogapp.handler.RecycleViewAdapter;
import com.toru.blogapp.model.itemes;
import com.toru.blogapp.model.responceResult;
import com.toru.blogapp.retrofit.ApiClient;
import com.toru.blogapp.retrofit.ApiInterface;

import java.io.IOException;
import java.net.URL;
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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DataParse dataParse;

    public HomeFragment() {
        // Required empty public constructor
    }


    /***
     * this is use por test parpuse
     *
     *
     *
     *
     */


    private String key = "AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM";
    final String TAG = "homefrgment";
    private ApiInterface apiInterface;
    private responceResult ResponceResult;

    String stringPosts ="start ";
    private RecyclerView recyclerView;
    Deque<Post> posts = new LinkedList<>();
    boolean dataIsLoad = false;




    private String getImageString(String content) {

        String reg = "href=[\\'\"]?([^\\'\" >]+)";
        Pattern r = Pattern.compile(reg);

        // Now create matcher object.
        Matcher m = r.matcher(content);
        if (m.find()) {
            //System.out.println("Found value: " + m.group(0) );
            return m.group(1);

        }
        return null;


    }








/*



finished
 */


    // TODO: Rename and change types and number of parameters
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













    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.home_recyctleView);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

               Call<responceResult> call = apiInterface.getResult("AIzaSyC-eE8XmFlgetyAgbX5xLoon920vcuQwSM");
               call.enqueue(new Callback<responceResult>() {


                   @Override
                   public void onResponse(Call<responceResult> call, Response<responceResult> response) {
                       //Log.i(TAG, "______________________come to responce section ______________________________");
                       //Log.i(TAG, response.isSuccessful() ? "TRUE" : "FALSE");
                       if (response.isSuccessful()) {
                           // Log.i(TAG, "___________________come to responce seccessfull");
                           if (response.body() != null) {
                               // Log.i(TAG, "go to responce body____________________");
                               ResponceResult = response.body();
                               // Log.i(TAG, "_______________" + ResponceResult.kind);


                               for (int i = 0; i < ResponceResult.Items.size(); i++) {
                                   final Post post = new Post();
                                   Log.i(TAG, ResponceResult.Items.get(i).title);
                                   post.setTitle(ResponceResult.Items.get(i).title);
                                   post.setTime(ResponceResult.Items.get(i).published);
                                   post.setPostUrl(ResponceResult.Items.get(i).url);
                                   post.setImage(getImageString(ResponceResult.Items.get(i).content));
                                   posts.add(post);

                               }

                               RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(), (List<Post>) posts);
                               recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                               recyclerView.setAdapter(recycleViewAdapter);
                               dataIsLoad = true;

                           }

                       } else {
                           Log.i(TAG, "_______________NOT WORKING ______________________________________");
                           //textView.setText(response.errorBody().toString());
                       }
                   }

                   @Override
                   public void onFailure(Call<responceResult> call, Throwable t) {
                       Log.i(TAG, "_____________________failer _______________________________________");
                       //textView.setText(t.toString());

                   }
               });






        return view;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }


}
