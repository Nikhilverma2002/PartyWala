package com.example.partywala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class Cart extends AppCompatActivity {

    TextView proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        proceed = findViewById(R.id.place);

        proceed.setOnClickListener(v->{
            if (getSupportFragmentManager().findFragmentById(R.id.cart) != null) {
                getSupportFragmentManager()
                        .beginTransaction().
                        remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.cart))).commit();
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cart, new OrderSummary())
                    .commit();
        });

        Window window = Cart.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Cart.this, R.color.myntra_red));
    }

}