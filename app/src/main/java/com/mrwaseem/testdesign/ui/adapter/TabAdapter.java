package com.mrwaseem.testdesign.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrwaseem.testdesign.R;

import java.util.List;


public class TabAdapter extends RecyclerView.Adapter<TabAdapter.ViewHolder> {
    private List<String> data;
    private Context mContext;

    public TabAdapter(Context context, List<String> data) {
        this.data = data;
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tab, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        if (position == 0) {
            viewHolder.imageSearch.setVisibility(View.VISIBLE);
            viewHolder.linearText.setVisibility(View.GONE);
        } else {
            viewHolder.imageSearch.setVisibility(View.GONE);
            viewHolder.linearText.setVisibility(View.VISIBLE);
        }
        if (position == 1) {
            viewHolder.linearText.setVisibility(View.VISIBLE);
            viewHolder.fSelected.setVisibility(View.VISIBLE);
            viewHolder.textName.setTextColor(mContext.getResources().getColor(R.color.colorRed));
        }
    }

    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageSearch;
        FrameLayout fSelected;
        LinearLayout linearText;
        TextView textName;

        ViewHolder(View view) {
            super(view);
            linearText = view.findViewById(R.id.linearText);
            imageSearch = view.findViewById(R.id.imageSearch);
            fSelected = view.findViewById(R.id.fSelected);
            textName = view.findViewById(R.id.textName);
        }
    }
}

