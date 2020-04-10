package com.example.neera.fragmentassignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Neera on 28/09/17.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    Context context;
    ArrayList<Model> models;

    public ModelAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new ModelAdapter.ModelViewHolder(li.inflate(R.layout.list_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ModelViewHolder extends RecyclerView.ViewHolder {

        public ModelViewHolder(View itemView) {
            super(itemView);
        }

        void bindView(Model model) {
            MyFragment fragment = new MyFragment();
           /* Fragment frag = getFragmentManager().findFragmentById(R.id.yourFragment);
            ((TextView) frag.getView().findViewById(R.id.textView)).setText(s);*/
        }
    }
}
