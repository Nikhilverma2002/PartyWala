package com.example.partywala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Otp extends AppCompatActivity {


    TextView textView, verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        textView = findViewById(R.id.content);
        verify = findViewById(R.id.verify);

        setStatusBarTransparent();
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        textView.setText("Enter the OTP sent to +91 "+ str);

        verify.setOnClickListener(v->{
            Intent intent1 = new Intent(Otp.this,Home.class);
            startActivity(intent1);
            finishAffinity();
        });
    }

    private void setStatusBarTransparent () {
        Window window = Otp.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}