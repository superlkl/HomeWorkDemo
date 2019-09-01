package com.example.mythirddemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mythirddemo.R;

import java.util.List;


public class SystemRecommendAdapter extends RecyclerView.Adapter<SystemRecommendAdapter.ViewHolder> {
    private List<RecommendSingsClass> list;
    private Context mContext;

    public SystemRecommendAdapter(List<RecommendSingsClass>list){
        this.list=list;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView singerName,singName;
        ImageView imageView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            singerName=itemView.findViewById(R.id.recommend_item_singerName);
            singName=itemView.findViewById(R.id.recommend_item_singName);
            imageView=itemView.findViewById(R.id.recommend_item_img);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.recommend_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecommendSingsClass recommendSings=list.get(position);
        holder.singName.setText(recommendSings.getSingName());
        holder.singerName.setText(recommendSings.getSingerName());
        Glide.with(mContext).load(recommendSings.getImageId()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}