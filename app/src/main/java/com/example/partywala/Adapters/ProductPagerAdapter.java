package com.example.partywala.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.partywala.Model.Product_items;
import com.example.partywala.Model.intro_ScreenItem;
import com.example.partywala.R;

import java.util.List;
import java.util.Objects;

public class ProductPagerAdapter extends PagerAdapter {

    Context mContext ;
    //List<Product_items> mListScreen;
    int[] images;

    public ProductPagerAdapter(Context mContext, int[] images) {
        this.mContext = mContext;
        this.images = images;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.product_layout_screen,null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);


        imgSlide.setImageResource(images[position]);

        Objects.requireNonNull(container).addView(layoutScreen);

        return layoutScreen;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
