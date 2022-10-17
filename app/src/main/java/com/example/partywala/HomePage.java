package com.example.partywala;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.partywala.Adapters.ProductPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment {

    View view;
    Context contextNullSafe;
    LinearLayout product;
    TextView view_all;


    ProductPagerAdapter productPagerAdapter;
    TabLayout tabIndicator;
    int[] images = {
            R.drawable.example, R.drawable.example, R.drawable.ic_deliver_boy
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_page, container, false);

        product = view.findViewById(R.id.boss);

        view_all = view.findViewById(R.id.view_all);

        view_all.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , SubCategoryAc.class);
            startActivity(intent);
        });

        product.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , Product_info.class);
            startActivity(intent);
        });

        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        List<SlideModel> imageList = new ArrayList<>();// Create image list
        imageList.add(new SlideModel(R.drawable.ic_bday, "Birthday Accessories", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.slider, "New Year Accessories", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_balloon, "Balloons & Accessories", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_delivery, "Free Delivery over ₹500",ScaleTypes.CENTER_CROP));
       // imageList.add(new SlideModel("https://bit.ly/2BteuF2", ScaleTypes.valueOf("Elephants and tigers may become extinct.")));
       // imageList.add(new SlideModel("https://bit.ly/3fLJf72", ScaleTypes.valueOf("The population of elephants is decreasing in the world.")));

        imageSlider.setImageList(imageList);

        /*imageSlider.setItemClickListener(new ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here.
            }
        })*/

        /*imageSlider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
                //println("Pos: " + position)
            }
        })*/

        ViewPager screenPager = view.findViewById(R.id.offer_screen_viewpager);
        tabIndicator = view.findViewById(R.id.tab_indicator);
        productPagerAdapter = new ProductPagerAdapter(getContext(), images);
        screenPager.setAdapter(productPagerAdapter);
        // setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

       /* imageSlider.setTouchListener(object : TouchListener {
            override fun onTouched(touched: ActionTypes) {
                if (touched == ActionTypes.DOWN){
                    imageSlider.stopSliding()
                } else if (touched == ActionTypes.UP ) {
                    imageSlider.startSliding(1000)
                }
            }
        })*/


        return view;

    }

    public Context getContextNullSafety() {
        if (getContext() != null) return getContext();
        if (getActivity() != null) return getActivity();
        if (contextNullSafe != null) return contextNullSafe;
        if (getView() != null && getView().getContext() != null) return getView().getContext();
        if (requireContext() != null) return requireContext();
        if (requireActivity() != null) return requireActivity();
        if (requireView() != null && requireView().getContext() != null)
            return requireView().getContext();

        return null;

    }

}