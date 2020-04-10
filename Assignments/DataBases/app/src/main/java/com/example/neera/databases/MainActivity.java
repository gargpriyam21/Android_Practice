package com.example.neera.databases;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.neera.databases.db.TodoDbHelper;
import com.example.neera.databases.db.tables.TodoTable;
import com.example.neera.databases.models.Todo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvTodos;
    EditText etNewTodo;
    Button btnAddTodo;
    ImageView ivDelete;
    ArrayList<Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase todoDb = new TodoDbHelper(this).getWritableDatabase();

        rvTodos = (RecyclerView) findViewById(R.id.rvTodos);
        etNewTodo = (EditText) findViewById(R.id.etNewTodo);
        btnAddTodo = (Button) findViewById(R.id.btnAddTodo);
        ivDelete = (ImageView) findViewById(R.id.ivDelete);
        todos = TodoTable.getAllTodos(todoDb);

        final TodoAdapter todoArrayAdapter = new TodoAdapter();
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        rvTodos.setAdapter(todoArrayAdapter);

        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long todoId = TodoTable.insertTodo(
                        todoDb,
                        new Todo(etNewTodo.getText().toString(), false)
                );

                todos = TodoTable.getAllTodos(todoDb);
                todoArrayAdapter.notifyDataSetChanged();
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

        @Override
        public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TodoViewHolder(getLayoutInflater().inflate(R.layout.list_item_todo, parent, false));
        }

        @Override
        public void onBindViewHolder(TodoViewHolder holder, int position) {
            holder.cbTodoTitle.setText(todos.get(position).getTask());
            holder.cbTodoTitle.setChecked(todos.get(position).isDone());
        }

        @Override
        public int getItemCount() {
            return todos.size();
        }

        class TodoViewHolder extends RecyclerView.ViewHolder {
            CheckBox cbTodoTitle;

            public TodoViewHolder(View itemView) {
                super(itemView);
                cbTodoTitle = itemView.findViewById(R.id.cbTodoTitle);
            }
        }
    }
}
