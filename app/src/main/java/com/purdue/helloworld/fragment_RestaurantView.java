package com.purdue.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.purdue.helloworld.R;
import com.purdue.helloworld.Restaurant;
import com.purdue.helloworld.RestaurantAdapter;

import java.util.ArrayList;
import java.util.List;

public class fragment_RestaurantView  extends Fragment {
    List<Restaurant> places = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_restaurantview, container, false);
        RestaurantAdapter adapter = new RestaurantAdapter(places);
        recyclerView = view.findViewById(R.id.rv);
       //add strings for each restaurant
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;


    }
}

