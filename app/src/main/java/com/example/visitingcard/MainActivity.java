package com.example.visitingcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickOpenGitHub(View view) {
        Intent intentOpenGitHub = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/snigdha-dhew"));
        startActivity(intentOpenGitHub);
    }

    public void onClickMail (View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:jucse29.360@gmail.com")); // Replace with your email
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject here");
        intent.putExtra(Intent.EXTRA_TEXT, "Body of the email");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+01793645738")); // Replace with the actual phone number

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}