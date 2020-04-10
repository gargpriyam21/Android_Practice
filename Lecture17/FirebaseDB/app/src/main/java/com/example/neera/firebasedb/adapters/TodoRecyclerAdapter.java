package com.example.neera.firebasedb.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Neera on 22/10/17.
 */

public class TodoRecyclerAdapter {
    private Context context;




    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView text1;

        public TodoViewHolder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
        }
    }
}
