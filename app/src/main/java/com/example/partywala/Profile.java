package com.example.partywala;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import javax.xml.transform.Result;


public class Profile extends Fragment {

    View view;
    CardView cardView;
    LinearLayout orders, saved_add, offers, edit_profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_account, container, false);
        cardView = view.findViewById(R.id.cardView);
        orders = view.findViewById(R.id.layout);
        saved_add = view.findViewById(R.id.saved_add);
        offers = view.findViewById(R.id.offers);

        edit_profile = view.findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , EditProfile.class);
            startActivity(intent);
        });
        offers.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , Offers.class);
            startActivity(intent);
        });

        saved_add.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , SavedAddress.class);
            startActivity(intent);
        });

        orders.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , Your_orders.class);
            startActivity(intent);
        });

        cardView.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , EditProfile.class);
            startActivity(intent);
        });

        return view;
    }
}