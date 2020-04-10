package com.example.neera.assignmentadd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neera on 30/08/17.
 */



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CourseViewHolder> {
    Context context;
    ArrayList<Course> courses;

    public RecyclerAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }




    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_card, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courses.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.tvCourse.setText(courses.get(position).getName());
        holder.tvTeacher.setText(courses.get(position).getTeacher());
        holder.tvClass.setText(courses.get(position).getClasses().toString());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    public class CourseViewHolder extends RecyclerView.ViewHolder {

        TextView tvCourse, tvTeacher, tvClass;
        ImageView ivDelete;

        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourse = itemView.findViewById(R.id.tvCourse);
            tvTeacher = itemView.findViewById(R.id.tvTeacher);
            tvClass = itemView.findViewById(R.id.tvClass);
            ivDelete = itemView.findViewById(R.id.ivDelete);


        }
    }
}
