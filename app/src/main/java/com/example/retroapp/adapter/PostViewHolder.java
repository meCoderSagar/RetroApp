package com.example.retroapp.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retroapp.R;

public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView tvlogin, tvid, tvrepourl;
    CheckBox cbstatus;


    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        tvlogin = itemView.findViewById(R.id.tvlogin);
        tvid = itemView.findViewById(R.id.tvid);
        tvrepourl = itemView.findViewById(R.id.tvrepourl);
        cbstatus = itemView.findViewById(R.id.cbstatus);

    }
}
