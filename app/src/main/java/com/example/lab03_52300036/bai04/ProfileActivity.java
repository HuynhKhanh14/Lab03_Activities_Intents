package com.example.lab03_52300036.bai04;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab03_52300036.R;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imgAvatar;
    private TextView tvUsername, tvTitle, tvName, tvPhone, tvEmail, tvAddress, tvHomepage;

    private final ActivityResultLauncher<Intent> editLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> bindData());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai04_activity_profile);

        imgAvatar  = findViewById(R.id.imgAvatar);
        tvUsername = findViewById(R.id.tvUsername);
        tvTitle    = findViewById(R.id.tvTitle);
        tvName     = findViewById(R.id.tvName);
        tvPhone    = findViewById(R.id.tvPhone);
        tvEmail    = findViewById(R.id.tvEmail);
        tvAddress  = findViewById(R.id.tvAddress);
        tvHomepage = findViewById(R.id.tvHomepage);

        findViewById(R.id.btnEdit).setOnClickListener(v -> {
            Intent i = new Intent(this, EditProfileActivity.class);
            editLauncher.launch(i);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindData();
    }

    private void bindData() {
        tvUsername.setText(UserProfile.username);
        tvTitle.setText(UserProfile.title);
        tvName.setText(UserProfile.name);
        tvPhone.setText(UserProfile.phone);
        tvEmail.setText(UserProfile.email);
        tvAddress.setText(UserProfile.address);
        tvHomepage.setText(UserProfile.homepage);

        if (!UserProfile.avatarUri.isEmpty()) {
            try {
                imgAvatar.setImageURI(Uri.parse(UserProfile.avatarUri));
            } catch (Exception e) {
                imgAvatar.setImageResource(android.R.drawable.ic_menu_myplaces);
            }
        } else {
            imgAvatar.setImageResource(android.R.drawable.ic_menu_myplaces);
        }
    }
}