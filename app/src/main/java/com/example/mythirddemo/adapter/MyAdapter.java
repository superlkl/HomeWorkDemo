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

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MyTop> list;
    private Context mContext;
    private List<String> web = new ArrayList<>();

    public MyAdapter(List<MyTop> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.my_text);
            imageView = itemView.findViewById(R.id.my_img);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyTop myTop = list.get(position);
        holder.textView.setText(myTop.getName());
        holder.imageView.setImageResource(myTop.getImageId());
        Glide.with(mContext).load(myTop.getImageId()).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}

