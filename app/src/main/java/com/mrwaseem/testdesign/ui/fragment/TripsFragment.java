package com.mrwaseem.testdesign.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrwaseem.testdesign.R;
import com.mrwaseem.testdesign.ui.adapter.TripsAdapter;

import java.util.ArrayList;

public class TripsFragment extends Fragment {

    TripsAdapter tripsAdapter;
    RecyclerView recyclerTrips;
    ArrayList<String> data = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trips, container, false);
        recyclerTrips = v.findViewById(R.id.recyclerTrips);
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        recyclerTrips.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        tripsAdapter = new TripsAdapter(getContext(),data);
        recyclerTrips.setAdapter(tripsAdapter);
        return v;
    }
}