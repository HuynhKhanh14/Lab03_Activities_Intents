package com.example.lab03_52300036.bai04;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab03_52300036.R;

public class EditProfileActivity extends AppCompatActivity {

    private ImageView imgAvatar;
    private EditText edtTitle, edtName, edtPhone, edtEmail, edtAddress, edtHomepage;

    private final ActivityResultLauncher<Intent> cameraLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == Activity.RESULT_OK
                                && result.getData() != null
                                && result.getData().getExtras() != null) {
                            android.graphics.Bitmap bmp =
                                    (android.graphics.Bitmap) result.getData()
                                            .getExtras().get("data");
                            imgAvatar.setImageBitmap(bmp);
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai04_activity_edit_profile);

        imgAvatar   = findViewById(R.id.imgAvatarEdit);
        edtTitle    = findViewById(R.id.edtTitle);
        edtName     = findViewById(R.id.edtName);
        edtPhone    = findViewById(R.id.edtPhone);
        edtEmail    = findViewById(R.id.edtEmail);
        edtAddress  = findViewById(R.id.edtAddress);
        edtHomepage = findViewById(R.id.edtHomepage);
        Button btnSave = findViewById(R.id.btnSaveProfile);
        TextView tvHeader = findViewById(R.id.tvHeaderEdit);

        tvHeader.setText(UserProfile.username);

        // Load dữ liệu hiện tại
        if (!UserProfile.avatarUri.isEmpty()) {
            try {
                imgAvatar.setImageURI(Uri.parse(UserProfile.avatarUri));
            } catch (Exception ignored) {}
        } else {
            imgAvatar.setImageResource(android.R.drawable.ic_menu_myplaces);
        }
        edtTitle.setText(UserProfile.title);
        edtName.setText(UserProfile.name);
        edtPhone.setText(UserProfile.phone);
        edtEmail.setText(UserProfile.email);
        edtAddress.setText(UserProfile.address);
        edtHomepage.setText(UserProfile.homepage);

        // Nhấn avatar → mở camera
        imgAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraLauncher.launch(intent);
        });

        // Nút Save
        btnSave.setOnClickListener(v -> {
            UserProfile.title    = edtTitle.getText().toString().trim();
            UserProfile.name     = edtName.getText().toString().trim();
            UserProfile.phone    = edtPhone.getText().toString().trim();
            UserProfile.email    = edtEmail.getText().toString().trim();
            UserProfile.address  = edtAddress.getText().toString().trim();
            UserProfile.homepage = edtHomepage.getText().toString().trim();

            setResult(RESULT_OK);
            finish();
        });
    }
}