package com.purdue.helloworld.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.purdue.helloworld.R;

import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    String retrievedValue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        String test = "Monday-Breakfast-8-10-Lunch-11-2-Dinner-6-8(5),Saturday-Breakfast-8-10-Lunch-11-2-Dinner-0-0";
        //Map<String, String> map = new HashMap<>();
        // map.put("test",test);
        //FirebaseFirestore.getInstance().collection("Restaurants").document("Wiley").set(map);
        FirebaseFirestore.getInstance().collection("Restaurants").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                                                                          @Override
                                                                                          public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
                                                                                              if (error == null) {
                                                                                                  for (DocumentSnapshot d : queryDocumentSnapshots) {
                                                                                                      retrievedValue = d.get("test").toString();
                                                                                                      parseString(retrievedValue);
                                                                                                  }
                                                                                              }
                                                                                          }
                                                                                      }
        );
        return root;
    }

    private void parseString(String retrievedValue) {
        String[] split = retrievedValue.split(",");
        String breakfast = "";
        String breakfasthours = "";
        String lunch = "";
        String lunchhours = "";
        String dinner = "";
        String dinnerhours = "";
        int repeat = 0;
        System.out.println(split);
        String test = "Monday-Breakfast-8-10-Lunch-11-2-Dinner-6-8(5),Saturday-Breakfast-8-10-Lunch-11-2-Dinner-0-0";
        for (String s : split) {
            int index = s.indexOf("-");
            //gets day
            String day = s.substring(0, index);
            System.out.println(day);
            s = s.substring(index + 1);
            int index2 = s.indexOf("-");

            while (index2 != -1) {
                //gets breakfast
                if (s.substring(0, index2).equals("Breakfast")) {
                    //gets breakfast
                    breakfast = s.substring(0, index2);
                    //cuts breakfast and -
                    s = s.substring(index2 + 1);
                    //index of - after first time
                    int indextemp = s.indexOf("-");
                    //adding start time
                    //8
                    breakfasthours += s.substring(0, indextemp);
                    breakfasthours += "-";
                    s = s.substring(indextemp + 1);
                    //getting index of dash after second time
                    int indextemp2 = s.indexOf("-");
                    //adding second time
                    breakfasthours += s.substring(0, indextemp2);
                    s = s.substring(indextemp2 + 1);
                    index2 = s.indexOf("-");

                } else if (s.substring(0, index2).equals("Lunch")) {
                    //gets lunch
                    lunch = s.substring(0, index2);
                    //cuts breakfast and -
                    s = s.substring(index2 + 1);
                    //index of - after first time
                    int indextemp = s.indexOf("-");
                    //adding start time
                    lunchhours += s.substring(0, indextemp);
                    lunchhours += "-";
                    s = s.substring(indextemp + 1);
                    //getting index of dash after second time
                    int indextemp2 = s.indexOf("-");
                    //adding second time
                    lunchhours += s.substring(0, indextemp2);
                    s = s.substring(indextemp2 + 1);
                    index2 = s.indexOf("-");
                } else {
                    //gets dinner
                    dinner = s.substring(0, index2);
                    //cuts dinner and -
                    s = s.substring(index2 + 1);
                    //index of - after first time
                    int indextemp = s.indexOf("-");
                    //adding start time
                    //8
                    dinnerhours += s.substring(0, indextemp);
                    dinnerhours += "-";
                    s = s.substring(indextemp + 1);
                    //getting index of dash after second time
                    int indextemp2 = s.indexOf("(");
                    //adding second time
                    dinnerhours += s.substring(0, indextemp2);
                    s = s.substring(indextemp2 + 1);
                    //causes while loop to stop
                    index2 = -1;
                    repeat = Integer.parseInt(s.substring(0, 1));
                    System.out.println("Repeat: " + repeat);


                }
                System.out.println(breakfast);
                System.out.println(breakfasthours);
                System.out.println(lunch);
                System.out.println(lunchhours);
                System.out.println(dinner);
                System.out.println(dinnerhours);

            }
        }


    }
}