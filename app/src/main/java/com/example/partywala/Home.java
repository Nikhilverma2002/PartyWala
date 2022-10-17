package com.example.partywala;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class Home extends AppCompatActivity {

    SmoothBottomBar bottomBar;
    Toolbar toolbar;
    NavigationView navView;
    LinearLayout product;
    OnBackPressedListener onBackpressedListener;
    DrawerLayout drawer;
    ImageView cart, whislist;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        navView = findViewById(R.id.navView);
        drawer = findViewById(R.id.drawer);
        cart = findViewById(R.id.cart);
        whislist = findViewById(R.id.whislist);




        setSupportActionBar(toolbar);

        //set default home fragment and its title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Home");
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomePage()).commit();
        navView.setCheckedItem(R.id.nav_home);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.main_blue));
        toggle.syncState();


        cart.setOnClickListener(v->{
            Intent intent = new Intent(Home.this, Cart.class);
            startActivity(intent);
        });
        whislist.setOnClickListener(v->{
            Intent intent = new Intent(Home.this, Whislist.class);
            startActivity(intent);
        });

        //navigation item click
        //navView.setItemIconTintList(ColorStateList.valueOf(R.color.main_blue));
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment = null;

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomePage();
                        drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;

                    case R.id.nav_contactUs:
                       /* fragment = new HomePage();
                        drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;*/

                    case R.id.nav_aboutUs:
                       /* fragment = new HomePage();
                        drawer.closeDrawer(GravityCompat.START);
                        //  getSupportActionBar().setTitle("About US");
                        callFragment(fragment);
                        break;*/

                }
                return true;
            }
        });

        setStatusBarTransparent();
        //loading the another fragment in viewPager


       /* Window window = Home.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Home.this, R.color.main_pink));*/


        if (getSupportFragmentManager().findFragmentById(R.id.container) != null) {
            getSupportFragmentManager()
                    .beginTransaction().
                    remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.container))).commit();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new HomePage())
                .commit();

        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setItemActiveIndex(0);
        bottomBar.setOnItemSelectedListener((OnItemSelectedListener) i -> {
            if (i == 0) {
                bottomBar.setItemActiveIndex(0);
                /*Intent intent = new Intent(Home.this , Home.class);
                startActivity(intent);*/

                if (getSupportFragmentManager().findFragmentById(R.id.container) != null) {
                    getSupportFragmentManager()
                            .beginTransaction().
                            remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.container))).commit();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new HomePage())
                        .commit();
            } else if (i == 1) {
                bottomBar.setItemActiveIndex(1);
                if (Home.this.getSupportFragmentManager().findFragmentById(R.id.container) != null) {
                    Home.this.getSupportFragmentManager()
                            .beginTransaction().
                            remove(Objects.requireNonNull(Home.this.getSupportFragmentManager().findFragmentById(R.id.container))).commit();
                }
                Home.this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Categories(), "list_announcement")
                        .commit();
            } else if (i == 2) {
                bottomBar.setItemActiveIndex(2);
                if (Home.this.getSupportFragmentManager().findFragmentById(R.id.container) != null) {
                    Home.this.getSupportFragmentManager()
                            .beginTransaction().
                            remove(Objects.requireNonNull(Home.this.getSupportFragmentManager().findFragmentById(R.id.container))).commit();
                }
                Home.this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Profile(), "list_announcement")
                        .commit();
            }
            return false;
        });

    }


    private void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //on backpress
    @Override
    public void onBackPressed() {
        if (onBackpressedListener != null) {
            getSupportActionBar().setTitle("Home");
            navView.setCheckedItem(R.id.nav_home);
            onBackpressedListener.doBack();
            drawer.closeDrawer(GravityCompat.START);
        } else if (onBackpressedListener == null) {
            finish();
            super.onBackPressed();
        }
    }

    public interface OnBackPressedListener {
        void doBack();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackpressedListener = onBackPressedListener;
    }

    @Override
    protected void onDestroy() {
        onBackpressedListener = null;
        super.onDestroy();
    }

    private void setStatusBarTransparent () {
        Window window = Home.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}

