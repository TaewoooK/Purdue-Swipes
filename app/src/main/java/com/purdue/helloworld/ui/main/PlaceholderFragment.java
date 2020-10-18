package com.purdue.helloworld.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.purdue.helloworld.HoursAdapter;
import com.purdue.helloworld.R;
import com.purdue.helloworld.Utility;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
RecyclerView recyclerView;
    private static final String ARG_SECTION_NUMBER = "section_number";
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.rvHours);
       // Bundle bundle = this.getArguments();
      //  String time = null;

        //time = getArguments().getString("time", null);

        SharedPreferences mySharedPreferences = getContext().getSharedPreferences("time", Context.MODE_PRIVATE);



        String time = mySharedPreferences.getString("time", "");


       // String menu = bundle.getString("menu");
        HoursAdapter hoursAdapter = new HoursAdapter(Utility.parseString(time));
        hoursAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(hoursAdapter);

        return root;
    }
}