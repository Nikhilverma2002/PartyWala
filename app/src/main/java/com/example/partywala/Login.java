package com.example.partywala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView getOtp;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setStatusBarTransparent();
        getOtp = findViewById(R.id.get_otp);
        editText = findViewById(R.id.phone_number);

        getOtp.setOnClickListener(v->{
            Intent intent = new Intent(Login.this , Otp.class);
            String str = editText.getText().toString();
            intent.putExtra("message", str);
            startActivity(intent);
        });
    }

    private void setStatusBarTransparent () {
        Window window = Login.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

}