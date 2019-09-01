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
import com.example.mythirddemo.adapterclass.MyTop;
import com.example.mythirddemo.adapterclass.SubCollect;

import java.util.ArrayList;
import java.util.List;

public class OwnCollectAdapter extends RecyclerView.Adapter<OwnCollectAdapter.ViewHolder> {
    //只有图片和文字属性
    private List<SubCollect> list;
    private Context mContext;

    public OwnCollectAdapter(List<SubCollect> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.owncollect_txt_item);
            imageView = itemView.findViewById(R.id.owncollect_img_item);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.own_collect_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubCollect subCollect = list.get(position);
        holder.textView.setText(subCollect.getName());
        Glide.with(mContext).load(subCollect.getImageId()).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
