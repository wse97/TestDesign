package com.mrwaseem.testdesign.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrwaseem.testdesign.R;
import com.mrwaseem.testdesign.ui.activity.detailsActivity.DetailsActivity;

import java.util.List;


public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.ViewHolder> {
    private List<String> data;
    private Context mContext;

    public TripsAdapter(Context context, List<String> data) {
        this.data = data;
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rides, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(v -> mContext.startActivity(new Intent(mContext, DetailsActivity.class)));
    }

    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View view) {
            super(view);
        }
    }
}