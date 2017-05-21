package com.mohitum.recyclerviewdemo.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mohitum.recyclerviewdemo.R;

public class DemoViewHolder extends RecyclerView.ViewHolder {

    private TextView txtVwFirstName;
    private TextView txtVwLastName;
    private ImageView imgVwAvatar;

    public DemoViewHolder(View itemView) {
        super(itemView);
        imgVwAvatar = (ImageView) itemView.findViewById(R.id.imgVwAvatar);
        txtVwFirstName = (TextView) itemView.findViewById(R.id.txtVwFirstName);
        txtVwLastName = (TextView) itemView.findViewById(R.id.txtVwLastName);
    }

    public TextView getTxtVwFirstName() {
        return txtVwFirstName;
    }

    public void setTxtVwFirstName(TextView txtVwFirstName) {
        this.txtVwFirstName = txtVwFirstName;
    }

    public TextView getTxtVwLastName() {
        return txtVwLastName;
    }

    public void setTxtVwLastName(TextView txtVwLastName) {
        this.txtVwLastName = txtVwLastName;
    }

    public ImageView getImgVwAvatar() {
        return imgVwAvatar;
    }

    public void setImgVwAvatar(ImageView imgVwAvatar) {
        this.imgVwAvatar = imgVwAvatar;
    }
}
