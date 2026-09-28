package com.example.lab03_52300036;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab03_52300036.bai01.LoginActivity;
import com.example.lab03_52300036.bai02.OpenBrowserActivity;
import com.example.lab03_52300036.bai04.ProfileActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBai1 = findViewById(R.id.btnBai1);
        Button btnBai2 = findViewById(R.id.btnBai2);
        Button btnBai4 = findViewById(R.id.btnBai4);

        btnBai1.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));
        btnBai2.setOnClickListener(v ->
                startActivity(new Intent(this, OpenBrowserActivity.class)));
        btnBai4.setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));
    }
}