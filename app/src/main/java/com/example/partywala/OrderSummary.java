package com.example.partywala;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class OrderSummary extends Fragment {

   View view;
   TextView proceed , change;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order_summary, container, false);

        proceed = view.findViewById(R.id.tv_go_to_pay);
        change = view.findViewById(R.id.change);

        change.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), SavedAddress.class);
            startActivity(intent);
        });

        proceed.setOnClickListener(v->{
            Intent intent = new Intent(getActivity() , Payment.class);
            startActivity(intent);
        });


        return view;
    }
}