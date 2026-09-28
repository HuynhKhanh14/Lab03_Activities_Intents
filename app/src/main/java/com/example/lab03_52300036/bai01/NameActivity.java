package com.example.lab03_52300036.bai01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab03_52300036.R;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai01_activity_name);

        String email = getIntent().getStringExtra("email");

        TextView tvGreeting = findViewById(R.id.tvGreeting);
        EditText edtName = findViewById(R.id.edtName);
        Button btnSave = findViewById(R.id.btnSave);

        if (email != null) {
            tvGreeting.setText("Xin chào, " + email + ". Vui lòng nhập tên");
        }

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            if (name.isEmpty()) {
                edtName.setError("Vui lòng nhập tên");
                return;
            }
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}