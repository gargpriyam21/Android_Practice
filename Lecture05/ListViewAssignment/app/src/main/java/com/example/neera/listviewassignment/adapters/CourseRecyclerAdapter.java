package com.example.neera.listviewassignment.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.listviewassignment.R;
import com.example.neera.listviewassignment.models.Course;

import java.util.ArrayList;

/**
 * Created by Neera on 28/08/17.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {

    Context context;
    ArrayList<Course> courses;

    public CourseRecyclerAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.list_item_course_card,parent,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        holder.tvCourse.setText(courses.get(position).getName());
        holder.tvTeacher.setText(courses.get(position).getTeacherName());
        holder.tvDate.setText(courses.get(position).getStartDate());
        holder.tvClass.setText(courses.get(position).getClasses().toString());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    public class CourseViewHolder extends RecyclerView.ViewHolder {

        TextView tvCourse, tvTeacher, tvDate, tvClass;

        public CourseViewHolder(View itemView) {
            super(itemView);

            tvCourse = itemView.findViewById(R.id.tvCourse);
            tvTeacher = itemView.findViewById((R.id.tvTeacher));
            tvClass = itemView.findViewById(R.id.tvClass);
            tvDate = itemView.findViewById(R.id.tvDate);

        }
    }
}
