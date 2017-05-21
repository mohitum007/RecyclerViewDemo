package com.mohitum.recyclerviewdemo.presentation;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mohitum.recyclerviewdemo.models.Datum;
import com.mohitum.recyclerviewdemo.R;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoViewHolder>{

    private Activity mActivity;
    private List<Datum> data;

    public DemoAdapter(Activity mActivity, List<Datum> data) {
        this.mActivity = mActivity;
        this.data = data;
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_home, parent, false);
        return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {
        Datum datum = data.get(position);
        holder.getTxtVwFirstName().setText(datum.getFirstName());
        holder.getTxtVwLastName().setText(datum.getLastName());

        Glide.with(mActivity).load(datum.getAvatar()).placeholder(R.mipmap.ic_launcher).into(holder.getImgVwAvatar());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
