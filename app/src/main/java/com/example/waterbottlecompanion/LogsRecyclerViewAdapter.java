package com.example.waterbottlecompanion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class LogsRecyclerViewAdapter extends RecyclerView.Adapter<LogsRecyclerViewAdapter.MyViewHolder> {
    private final String TAG = "TAG, you're it";
    private ArrayList<String> times, quantity;
    private Context context;

    public LogsRecyclerViewAdapter(ArrayList<String> times, ArrayList<String> quantity, Context context) {
        this.times = times;
        this.quantity = quantity;
        this.context = context;
    }

    @NonNull
    @Override
    public LogsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.log_display_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogsRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.time.setText(times.get(position));
        holder.quantityConsumed.setText(quantity.get(position));
    }

    @Override
    public int getItemCount() {
        return times.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView quantityConsumed, time;

        public MyViewHolder(final View itemView) {
            super(itemView);
            quantityConsumed = itemView.findViewById(R.id.quantityConsumed);
            time = itemView.findViewById(R.id.timeOfConsumption);
        }
    }
}
