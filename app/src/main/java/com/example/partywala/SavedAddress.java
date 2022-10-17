package com.example.partywala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SavedAddress extends AppCompatActivity {

    TextView add_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_address);

        add_more = findViewById(R.id.add_address);

        Window window = SavedAddress.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(SavedAddress.this, R.color.myntra_red));

        add_more.setOnClickListener(v->{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.saved_address, new EditAddress())
                    .commit();
        });

    }
}