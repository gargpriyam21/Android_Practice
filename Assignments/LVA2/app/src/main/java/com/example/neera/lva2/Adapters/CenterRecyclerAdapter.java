package com.example.neera.lva2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.lva2.Models.Center;
import com.example.neera.lva2.R;

import java.util.ArrayList;

/**
 * Created by Neera on 29/08/17.
 */

public class CenterRecyclerAdapter extends RecyclerView.Adapter<CenterRecyclerAdapter.CenterViewHolder> {
    Context context;
    ArrayList<Center> centers;

    public CenterRecyclerAdapter(Context context, ArrayList<Center> centers) {
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
        holder.tvContact.setText(centers.get(position).getContactNumber());

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
            tvContact = itemView.findViewById(R.id.tvContact);

        }
    }


}
