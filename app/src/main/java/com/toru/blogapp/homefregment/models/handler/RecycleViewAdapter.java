package com.toru.blogapp.homefregment.models.handler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.toru.blogapp.R;
import com.toru.blogapp.homefregment.models.model.itemes;

import java.net.URL;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    //private final PublishSubject<String> onClickSubject = PublishSubject.create();
    Context mContext;
    List<itemes> mdata;

    public RecycleViewAdapter(Context mContext, List<itemes> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.tvContact.setText(mdata.get(position).getTitle());
        holder.tvbody.setText(mdata.get(position).published);
       /* if (mdata.get(position).getImage() != null) {


            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        URL url = new URL(mdata.get(position).getImage());
                       Bitmap bmp= BitmapFactory.decodeStream(url.openConnection().getInputStream());
                       holder.img.setImageBitmap(bmp);

                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();



        } else {
            //holder.img.setImageBitmap();
        }*/


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContact;
        private TextView tvbody;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContact = itemView.findViewById(R.id.title);
            tvbody = itemView.findViewById(R.id.time);
            img = itemView.findViewById(R.id.photo);


        }
    }
}
