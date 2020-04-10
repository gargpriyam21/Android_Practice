package com.example.neera.jsonapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.jsonapplication.R;
import com.example.neera.jsonapplication.models.User;

import java.util.ArrayList;

/**
 * Created by Neera on 26/09/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    ArrayList<User> users = new ArrayList<>();
    Context context;

    public UsersAdapter (Context context) {
        this.context = context;
    }

    public void updateUsers (ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new UserViewHolder(li.inflate(R.layout.list_item_users, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindView(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserName, tvUserUsername, tvUserEmail;
        TextView tvUserAddressCity, tvUserAddressZipcode;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
            tvUserUsername = itemView.findViewById(R.id.tvUserUsername);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserAddressCity = itemView.findViewById(R.id.tvUserAddressCity);
            tvUserAddressZipcode = itemView.findViewById(R.id.tvUserAddressZipcode);
        }

        void bindView(User user) {
            tvUserEmail.setText(user.getEmail());
            tvUserName.setText(user.getName());
            tvUserUsername.setText(user.getUsername());
            tvUserAddressCity.setText(user.getAddress().getCity());
            tvUserAddressZipcode.setText(user.getAddress().getZipcode());
        }
    }
}
