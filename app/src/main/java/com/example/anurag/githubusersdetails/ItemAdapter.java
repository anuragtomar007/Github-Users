package com.example.anurag.githubusersdetails;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anurag.githubusersdetails.controller.DetailActivity;
import com.example.anurag.githubusersdetails.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context context,List<Item> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getLogin());
        holder.githublink1.setText(items.get(position).getHtmlUrl());
//        Picasso.with(context)
//                .load(items.get(position).getAvatarUrl())
//                .placeholder(R.drawable.load)
//                .into(holder.imageView);
        Glide.with(context)
                .load(items.get(position).getAvatarUrl())
                .placeholder(R.drawable.load)
                .bitmapTransform(new GlideCircleTransformation(context))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title,githublink1,followers,repos;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            githublink1 = itemView.findViewById(R.id.githubLink);
            imageView = itemView.findViewById(R.id.cover);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos!=RecyclerView.NO_POSITION){
                        Item clickedDataItem = items.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login",items.get(pos).getLogin());
                        intent.putExtra("html_url",items.get(pos).getHtmlUrl());
                        intent.putExtra("avatar_url",items.get(pos).getAvatarUrl());
                        intent.putExtra("followers_url",items.get(pos).getFollowersUrl());
                        intent.putExtra("repos_url",items.get(pos).getRepoUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(context, "You clicked "+clickedDataItem.getLogin(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
