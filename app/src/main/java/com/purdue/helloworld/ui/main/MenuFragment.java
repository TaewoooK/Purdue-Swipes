package com.purdue.helloworld.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.purdue.helloworld.R;

public class MenuFragment extends Fragment {


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cardview_menu, container, false);
        SharedPreferences mySharedPreferences = getContext().getSharedPreferences("menu", Context.MODE_PRIVATE);
        String menu = mySharedPreferences.getString("menu", "");
        TextView t = root.findViewById(R.id.menu);
        t.setText(menu);
        System.out.println("menu" + menu);
        t.setVisibility(View.VISIBLE);
        return root;
    }
}

