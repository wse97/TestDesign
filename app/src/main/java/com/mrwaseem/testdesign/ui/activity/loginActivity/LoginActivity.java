package com.mrwaseem.testdesign.ui.activity.loginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mrwaseem.testdesign.R;
import com.mrwaseem.testdesign.ui.activity.mainActivity.MainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_login);

        TextView textNext = findViewById(R.id.textNext);
        textNext.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, MainActivity.class)));
    }
}