package com.example.retroapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retroapp.R;
import com.example.retroapp.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }



    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_row,parent,false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.tvlogin.setText(String.valueOf(postList.get(position).getUser().getLogin()));
        holder.tvid.setText(String.valueOf(postList.get(position).getId()));
        holder.tvrepourl.setText(String.valueOf(postList.get(position).getRepositoryUrl()));
        String State = String.valueOf(postList.get(position).getState());
        if(State.equalsIgnoreCase("open"))
        {
            holder.cbstatus.setChecked(true);
        }

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
