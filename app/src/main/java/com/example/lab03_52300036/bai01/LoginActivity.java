package com.example.lab03_52300036.bai01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab03_52300036.R;

public class LoginActivity extends AppCompatActivity {

    private TextView tvHello;
    private EditText edtEmail;
    private Button btnLogin;

    private final ActivityResultLauncher<Intent> nameLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                            String name = result.getData().getStringExtra("name");
                            tvHello.setText("Hẹn gặp lại\n\n" + name);
                            tvHello.setTextSize(24);
                            edtEmail.setVisibility(View.GONE);
                            btnLogin.setVisibility(View.GONE);
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai01_activity_login);

        tvHello = findViewById(R.id.tvHello);
        edtEmail = findViewById(R.id.edtEmail);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            if (email.isEmpty()) {
                edtEmail.setError("Vui lòng nhập email");
                return;
            }
            Intent intent = new Intent(this, NameActivity.class);
            intent.putExtra("email", email);
            nameLauncher.launch(intent);
        });
    }
}