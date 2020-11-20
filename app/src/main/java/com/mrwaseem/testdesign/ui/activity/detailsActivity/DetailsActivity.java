package com.mrwaseem.testdesign.ui.activity.detailsActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.mrwaseem.testdesign.R;
import com.mrwaseem.testdesign.ui.adapter.ProductAdapter;
import com.mrwaseem.testdesign.ui.adapter.TabAdapter;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    RecyclerView list, recyclerTab;
    ImageView icBack, icFav;
    ProductAdapter productAdapter;
    TabAdapter tabAdapter;
    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        list = findViewById(R.id.list);
        recyclerTab = findViewById(R.id.recyclerTab);
        setSupportActionBar(toolbar);
        StatusBarUtil.setDarkMode(this);
        StatusBarUtil.setColorForSwipeBack(this, Color.TRANSPARENT, 0);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        icBack = findViewById(R.id.icBack);
        icFav = findViewById(R.id.icFav);
        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbar_layout);
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener)
                (appBarLayout1, verticalOffset) -> {
            if (toolbarLayout.getHeight() + verticalOffset < 2 * ViewCompat.getMinimumHeight(toolbarLayout)) {
                StatusBarUtil.setLightMode(this);
                StatusBarUtil.setColor(this,Color.WHITE,0);
                toolbar.setBackgroundColor(Color.WHITE);
                icBack.setImageResource(R.drawable.ic_back_scrolling);
                icFav.setImageResource(R.drawable.ic_fav_scrolling);
                findViewById(R.id.groupTitleToolbar).setVisibility(View.VISIBLE);
            } else {
                StatusBarUtil.setDarkMode(this);
                toolbar.setBackgroundColor(Color.TRANSPARENT);
                icBack.setImageResource(R.drawable.ic_image_back_no_scroll);
                icFav.setImageResource(R.drawable.ic_fav_no_scroll);
                findViewById(R.id.groupTitleToolbar).setVisibility(View.GONE);
                StatusBarUtil.setColorForSwipeBack(this, Color.TRANSPARENT, 0);
            }

        });
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        productAdapter = new ProductAdapter(this, data);
        list.setAdapter(productAdapter);

        recyclerTab.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        tabAdapter = new TabAdapter(this, data);
        recyclerTab.setAdapter(tabAdapter);
    }

}
