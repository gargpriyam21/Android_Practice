package com.example.neera.jsonapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.jsonapplication.R;
import com.example.neera.jsonapplication.models.Post;

import java.util.ArrayList;

/**
 * Created by Neera on 10/09/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    ArrayList<Post> posts = new ArrayList<>();
    Context context;

    public PostsAdapter(Context context) {
        this.context = context;
    }

    public void updatePosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new PostViewHolder(li.inflate(R.layout.list_item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindView(posts.get(position));

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvPostBody, tvPostTitle;

        public PostViewHolder(View itemView) {
            super(itemView);
            tvPostBody = itemView.findViewById(R.id.tvPostBody);
            tvPostTitle = itemView.findViewById(R.id.tvPostTitle);
        }

        void bindView(Post post) {
            tvPostTitle.setText(post.getTitle());
            tvPostBody.setText(post.getBody());

        }
    }
}
