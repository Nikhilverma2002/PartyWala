package com.example.partywala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.partywala.Adapters.ProductPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Product_info extends AppCompatActivity {

    ProductPagerAdapter productPagerAdapter;
    TabLayout tabIndicator;
    TextView buy_now;
    int[] images = {
            R.drawable.example, R.drawable.example, R.drawable.example
    };


    //TODO : MAIN PINK #FE87AC

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);



        buy_now  = findViewById(R.id.buy_now);
        buy_now.setOnClickListener(v->{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.product_info, new OrderSummary())
                    .commit();

            Window window = Product_info.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(Product_info.this, R.color.myntra_red));
        });



        // setup viewpager
        ViewPager screenPager = findViewById(R.id.product_screen_viewpager);
        tabIndicator = findViewById(R.id.tab_indicator);
        productPagerAdapter = new ProductPagerAdapter(Product_info.this, images);
        screenPager.setAdapter(productPagerAdapter);
        // setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

       /* if (position < mList.size()) {
            position++;
            screenPager.setCurrentItem(position);
        }*/
        Window window = Product_info.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Product_info.this, R.color.myntra_red));

    }

  /*  private void setStatusBarTransparent () {
        Window window = Product_info.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(Color.TRANSPARENT);
    }*/

}