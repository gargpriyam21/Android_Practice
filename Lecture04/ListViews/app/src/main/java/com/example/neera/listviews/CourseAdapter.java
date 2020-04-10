package com.example.neera.listviews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neera on 26/08/17.
 */

public class CourseAdapter extends BaseAdapter {

    ArrayList<Course> courses;
    Context context;

    public CourseAdapter(ArrayList<Course> courses, Context context) {
        this.courses = courses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Course getItem(int i) {
        return courses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (itemView == null) {
            itemView = li.inflate(R.layout.list_item_view, viewGroup, false);
        } else {

        }

//        (itemView.findViewById(R.id.tvCourseName));
        ((TextView) itemView.findViewById(R.id.tvCourseName)).setText(getItem(i).getName());
        ((TextView) itemView.findViewById(R.id.tvCenter)).setText(getItem(i).getCenter());
        ((TextView) itemView.findViewById(R.id.tvClasses)).setText(getItem(i).getClasses().toString());

        return itemView;
    }
}
