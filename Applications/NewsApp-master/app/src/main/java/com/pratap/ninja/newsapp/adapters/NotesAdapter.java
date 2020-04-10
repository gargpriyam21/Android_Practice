package com.pratap.ninja.newsapp.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.activities.NotesActivity;
import com.pratap.ninja.newsapp.models.Notes;

import java.util.ArrayList;

import static com.pratap.ninja.newsapp.MainActivity.setMark;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private Context context;
    private ArrayList<Notes> notesList = new ArrayList<>();
    private static final String TAG = "NL";

    public NotesAdapter(Context context) {
        this.context = context;
    }

    public void updateNotes(ArrayList<Notes> notesList) {
        Log.d(TAG, "updateNews: " + notesList.size());
        this.notesList = notesList;
        notifyDataSetChanged();
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new NotesViewHolder(li.inflate(R.layout.item_list_notes, parent, false));
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        holder.bindView(notesList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + notesList.size());
        return notesList.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvdate, tvdes;
        ImageButton ibDelete;
        LinearLayout llNotes;
        NotesViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitleNotes);
            tvdate = itemView.findViewById(R.id.tvTimeNotes);
            tvdes = itemView.findViewById(R.id.tvDesNotes);
            ibDelete = itemView.findViewById(R.id.ibDelete);
            llNotes = itemView.findViewById(R.id.llNotesList);
        }

        void bindView(final Notes notes) {

            tvTitle.setText(notes.getTitle());
            tvdate.setText(notes.getDate());
            tvdes.setMaxLines(1);
            tvdes.setEllipsize(TextUtils.TruncateAt.END);
            tvdes.setText(notes.getBody());
            llNotes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setMark(false);
                    context.startActivity(new Intent(context, NotesActivity.class)
                            .putExtra("Id", notes.getId())
                            .putExtra("Title", notes.getTitle())
                            .putExtra("Body", notes.getBody())
                    );
                    Log.d(TAG, "onClick: " + notes.getTitle());
                    Log.d(TAG, "onClick: " + notes.getBody());
                }
            });

            ibDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Delete");
                    builder.setMessage("Do you want to delete this Note?").setPositiveButton("YES",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    context.startActivity(new Intent(context, NotesActivity.class)
                                            .putExtra("flag", 1)
                                            .putExtra("Id", notes.getId())
                                    );
                                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                }
                            }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                        }
                    }).create().show();
                }
            });

        }
    }
}
