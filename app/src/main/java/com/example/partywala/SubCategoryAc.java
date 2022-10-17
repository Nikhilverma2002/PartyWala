package com.example.partywala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.partywala.Adapters.SubCategoryAdapter;
import com.example.partywala.Model.SubCategoryModel;

import java.util.ArrayList;

public class SubCategoryAc extends AppCompatActivity {

    RecyclerView recyclerView;
    Context context;
    private ArrayList<SubCategoryModel> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        recyclerView = findViewById(R.id.rv_sub);
        recyclerDataArrayList=new ArrayList<>();

        Window window = SubCategoryAc.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(SubCategoryAc.this, R.color.white));

        recyclerDataArrayList.add(new SubCategoryModel("Boss Baby", R.drawable.ic_baby));
        recyclerDataArrayList.add(new SubCategoryModel("Bheem", R.drawable.ic_festival));
        recyclerDataArrayList.add(new SubCategoryModel("Doraemon", R.drawable.ic_balloon));
        recyclerDataArrayList.add(new SubCategoryModel("Bear", R.drawable.ic_festival));
        recyclerDataArrayList.add(new SubCategoryModel("Fight", R.drawable.ic_baby));
        recyclerDataArrayList.add(new SubCategoryModel("Fight", R.drawable.ic_baby));
        recyclerDataArrayList.add(new SubCategoryModel("Fight", R.drawable.ic_baby));
        recyclerDataArrayList.add(new SubCategoryModel("Fight", R.drawable.ic_baby));
        recyclerDataArrayList.add(new SubCategoryModel("Fight", R.drawable.ic_baby));

        SubCategoryAdapter adapter = new SubCategoryAdapter(recyclerDataArrayList, this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}