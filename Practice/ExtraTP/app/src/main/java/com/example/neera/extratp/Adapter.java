package com.example.neera.extratp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neera on 08/09/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.courseViewHolder> {

    Context context;
    ArrayList<Course> courses;

    public Adapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public courseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_card, parent, false);
        return new courseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(courseViewHolder holder, final int position) {
        holder.ivdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courses.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.tvName.setText(courses.get(position).getCourse());
        holder.tvTeacher.setText(courses.get(position).getTeacher());
        holder.tvClasses.setText(courses.get(position).getClasses().toString());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class courseViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvTeacher, tvClasses;
        ImageView ivdelete;

        public courseViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTeacher = itemView.findViewById(R.id.tvTeacher);
            tvClasses = itemView.findViewById(R.id.tvClasses);
            ivdelete = itemView.findViewById(R.id.ivdelete);
        }
    }
}
