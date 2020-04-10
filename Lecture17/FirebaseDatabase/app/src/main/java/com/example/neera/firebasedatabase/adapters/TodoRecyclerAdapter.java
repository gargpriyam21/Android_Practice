package com.example.neera.firebasedatabase.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.firebasedb.models.Todo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

/**
 * Created by Neera on 22/10/17.
 */

public class TodoRecyclerAdapter extends FirebaseRecyclerAdapter<Todo, TodoRecyclerAdapter.TodoViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    private Context context;

    public TodoRecyclerAdapter(FirebaseRecyclerOptions<Todo> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(TodoViewHolder holder, int position, Todo todo) {
        holder.text1.setText(todo.getTask());
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(android.R.layout.simple_list_item_1, parent, false);

        return new TodoViewHolder(itemView);
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView text1;

        public TodoViewHolder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
        }
    }
}
