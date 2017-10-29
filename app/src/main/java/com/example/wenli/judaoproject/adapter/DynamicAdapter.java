package com.example.wenli.judaoproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wenli.judaoproject.R;
import com.example.wenli.judaoproject.bean.DynamicItem;

import java.util.List;

/**
 * Created by wenli on 2017/10/27.
 */

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHolder> {
    private static final String TAG = "DynamicAdapter";
    private List<DynamicItem> mlist;
    private Context mContext;
    public DynamicAdapter(List<DynamicItem> list) {
        mlist = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext ==null){
            mContext = parent.getContext();
        }
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DynamicItem dynamicItem = mlist.get(position);
        Glide.with(mContext).load(dynamicItem.getImageUrl()).into(holder.imageView);
        Log.d(TAG, "onBindViewHolder: "+dynamicItem.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageglide);
        }
    }
}
