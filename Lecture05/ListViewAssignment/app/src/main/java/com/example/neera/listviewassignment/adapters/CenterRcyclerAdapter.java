package com.example.neera.listviewassignment.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.listviewassignment.R;
import com.example.neera.listviewassignment.models.Center;

import java.util.ArrayList;

/**
 * Created by Neera on 28/08/17.
 */

public class CenterRcyclerAdapter extends RecyclerView.Adapter<CenterRcyclerAdapter.CenterViewHolder> {

    Context context;
    ArrayList<Center> centers;

    public CenterRcyclerAdapter(Context context, ArrayList<Center> centers) {
        this.context = context;
        this.centers = centers;
    }

    @Override
    public CenterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_center_card, parent, false);
        return new CenterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CenterViewHolder holder, int position) {
        holder.tvLocation.setText(centers.get(position).getLocation());
        holder.tvCity.setText(centers.get(position).getCity());
        holder.tvContact.setText(centers.get(position).getContactnumber());

    }


    @Override
    public int getItemCount() {
        return centers.size();
    }

    public class CenterViewHolder extends RecyclerView.ViewHolder {

        TextView tvLocation, tvCity, tvContact;

        public CenterViewHolder(View itemView) {
            super(itemView);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvContact = itemView.findViewById((R.id.tvContact));
        }
    }


}
