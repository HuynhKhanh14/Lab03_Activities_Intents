package com.example.lab03_52300036.bai02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab03_52300036.R;

public class OpenBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai02_activity_open_browser);

        EditText edtUrl = findViewById(R.id.edtUrl);
        Button btnOpen = findViewById(R.id.btnOpen);

        btnOpen.setOnClickListener(v -> {
            String url = edtUrl.getText().toString().trim();
            if (url.isEmpty()) {
                edtUrl.setError("Vui lòng nhập link");
                return;
            }
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Không có trình duyệt nào!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}