package com.example.waterbottlecompanion;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ConnectFragment extends Fragment {
    private View rootview;
    private TextView currentBottle, logs, batteryPercentage;
    private RecyclerView logsRecyclerView;
    private ProgressBar batteryPercent, progressBar;
    private Context context;
    private LinearLayoutManager layoutManager;
    private LogsRecyclerViewAdapter logsDisplayAdapter;
    private ArrayList<String> times, quantities;

    private static final String TAG = "LogsFragment";

    //todo make edit text with UI of text view
    public ConnectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_logs, container, false);
        wireWidgets();
        return rootview;
    }

    private void wireWidgets() {
        context = getActivity();
        currentBottle = rootview.findViewById(R.id.currentBottle);
        currentBottle.setText("Water Bottle Name Here"); //todo change based on selected bottle
        logs = rootview.findViewById(R.id.logsTitle);
        logs.setText(R.string.logs_title);

        //todo make bluetooth %
        batteryPercent = rootview.findViewById(R.id.batteryPercent);
        batteryPercentage = rootview.findViewById(R.id.batteryPercentage);
        batteryPercent.setProgress(15);
        batteryPercentage.setText(""+batteryPercent.getProgress()+"%");

        if(batteryPercent.getProgress() > 20){
            batteryPercent.getProgressDrawable().setColorFilter(0xFF1FAA00, PorterDuff.Mode.SRC_IN);
            batteryPercentage.setTextColor(0xFF1FAA00);
        } else if(batteryPercent.getProgress() > 5){
            batteryPercent.getProgressDrawable().setColorFilter(0xFFFFAB00, android.graphics.PorterDuff.Mode.SRC_IN);
            batteryPercentage.setTextColor(0xFFFFAB00);
        } else {
            batteryPercent.getProgressDrawable().setColorFilter(0xFFDD2C00, android.graphics.PorterDuff.Mode.SRC_IN);
            batteryPercentage.setTextColor(0xFFDD2C00);
        }


        //todo make % of daily goal completed
        progressBar = rootview.findViewById(R.id.progressBar);
        progressBar.setProgress(80); //completed
        progressBar.setSecondaryProgress(90); //should have completed

        //todo make bluetooth values
        times = new ArrayList<>();
        quantities = new ArrayList<>();

        times.add("13:45");
        quantities.add("1 oz");
        times.add("18:45");
        quantities.add("15 oz");
        times.add("20:45");
        quantities.add("40 oz");
        times.add("22:45");
        quantities.add("10 oz");
        times.add("23:05");
        quantities.add("5 oz");

        //recycler view
        logsRecyclerView = rootview.findViewById(R.id.logsRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        logsRecyclerView.setLayoutManager(layoutManager);
        logsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        logsDisplayAdapter = new LogsRecyclerViewAdapter(times, quantities, context);
        logsRecyclerView.setAdapter(logsDisplayAdapter);
        registerForContextMenu(logsRecyclerView);

    }
}
