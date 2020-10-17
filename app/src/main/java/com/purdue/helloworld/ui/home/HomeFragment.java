package com.purdue.helloworld.ui.home;

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
import com.purdue.helloworld.utility;

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
                        for (DocumentSnapshot d:queryDocumentSnapshots){
                           retrievedValue = d.get("test").toString();
                           parseString(retrievedValue);
                        }
                    }
                    //fdggfdg
                }
            }
            );
        return root;
    }

    private void parseString(String retrievedValue) {
        String[] split = retrievedValue.split(",");
        System.out.println(split);
        for (String s: split) {
            int index = s.indexOf("-");
            //gets day
            String day = s.substring(0,index);
            System.out.println(day);
            s = s.substring(index+1);
            int index2 = s.indexOf("-");
            //gets breakfast
            String meal = s.substring(0,index2);
            System.out.println(meal);
        }
    }
}