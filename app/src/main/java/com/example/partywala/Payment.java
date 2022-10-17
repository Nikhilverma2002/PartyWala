package com.example.partywala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.furkanakdemir.surroundcardview.SurroundCardView;

public class Payment extends AppCompatActivity {

    SurroundCardView google_pay, amazon_pay, phone_pay, bhim, mobikwik, paytm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Window window = Payment.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Payment.this, R.color.myntra_red));

        google_pay = findViewById(R.id.google_pay);
        amazon_pay = findViewById(R.id.amazon_pay);
        phone_pay = findViewById(R.id.phone_pay);
        bhim = findViewById(R.id.bhim);
        paytm = findViewById(R.id.paytm);
        mobikwik = findViewById(R.id.mobikwik);

        google_pay.setOnClickListener(v->{


        if (!google_pay.isCardSurrounded()) {
            google_pay.setSurroundStrokeWidth(R.dimen.width_card);
            google_pay.surround();
            amazon_pay.release();
            phone_pay.release();
            bhim.release();
            paytm.release();
            mobikwik.release();
        }
        });


        amazon_pay.setOnClickListener(v -> {
            if (!amazon_pay.isCardSurrounded()) {
                amazon_pay.setSurroundStrokeWidth(R.dimen.width_card);
                amazon_pay.surround();
                google_pay.release();
                phone_pay.release();
                bhim.release();
                paytm.release();
                mobikwik.release();
            }
        });

        phone_pay.setOnClickListener(v -> {
            if (!phone_pay.isCardSurrounded()) {
                phone_pay.setSurroundStrokeWidth(R.dimen.width_card);
                phone_pay.surround();
                google_pay.release();
                amazon_pay.release();
                bhim.release();
                paytm.release();
                mobikwik.release();

            }
        });

        bhim.setOnClickListener(v -> {
            if (!bhim.isCardSurrounded()) {
                bhim.setSurroundStrokeWidth(R.dimen.width_card);
                bhim.surround();
                google_pay.release();
                amazon_pay.release();
                phone_pay.release();
                paytm.release();
                mobikwik.release();

            }
        });

        paytm.setOnClickListener(v -> {
            if (!paytm.isCardSurrounded()) {
                paytm.setSurroundStrokeWidth(R.dimen.width_card);
                paytm.surround();
                google_pay.release();
                amazon_pay.release();
                phone_pay.release();
                bhim.release();
                mobikwik.release();

            }
        });

        mobikwik.setOnClickListener(v -> {
            if (!mobikwik.isCardSurrounded()) {
                mobikwik.setSurroundStrokeWidth(R.dimen.width_card);
                mobikwik.surround();
                google_pay.release();
                amazon_pay.release();
                phone_pay.release();
                bhim.release();
                paytm.release();

            }
        });
    }
}