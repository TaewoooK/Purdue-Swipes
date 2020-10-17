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
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirestoreRegistrar;
import com.google.firebase.firestore.QuerySnapshot;
import com.purdue.helloworld.MealSwipeTime;
import com.purdue.helloworld.R;
import com.purdue.helloworld.Restaurant;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    String retrievedValue;
ArrayList<Restaurant> restaurants = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        //name,description,location,time,drawablepath,takeMealSwipes,OnlyMealSwipes
      /*  Restaurant aadr = new Restaurant("All American Dining Room", "The All American Dining Room - NEW THIS YEAR - FEATURING 1bowl, is another grab-and-go meal swipe option located in Cary Quadrangle offering a rotating assortment of specialty entrée bowls. Choose a hot or cold entreé bowl made to order with a fountain beverage.", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.aadr_time), "allamerican",true, true);
        Restaurant peteza = new Restaurant("Pete's Za", "Pete's Za at Meredith is a grab and go meal swipe option that serves a veriety of hot and ready pizza", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.peteza_time), "petesza", true,true);
        Restaurant onebowl = new Restaurant("1Bowl", "1bowl @ Meredith is a grab-and-go swipe meal plan option, available only for meal plan holders, located in 1North of the Gathering Place at Meredith Hall, featuring a rotating menu of specialty entrée bowls. Choose a hot or cold entreé bowl made to order with a fountain beverage.", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.onebowl_time),"onebowl", true, true);
        Restaurant caryKnightSpot = new Restaurant("Cary Knight Spot", "Open late to satisfy all your pub grub cravings- stop by for burgers, fries, quesadillas, tenders, and more. Located in the basement of Cary Quad South.","https://www.google.com/maps/place/Cary+Knight+Spot+Grill/@40.4317733,-86.9193086,17z/data=!3m1!4b1!4m5!3m4!1s0x8812fd4ca6441cb5:0x3be521b18709d11!8m2!3d40.4317692!4d-86.9171199",getString(R.string.caryknightspot_time),"caryknightspot",true,false);
        CollectionReference d =FirebaseFirestore.getInstance().collection("Restaurants");
        d.add(aadr);
        d.add(peteza);
        d.add(onebowl);
        d.add(caryKnightSpot);
        */



      /*  Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
        Restaurant amd = new Restaurant();
*/
      FirebaseFirestore.getInstance().collection("Restaurants").addSnapshotListener(new EventListener<QuerySnapshot>() {
          @Override
          public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
              restaurants.clear();
              for (DocumentSnapshot documentSnapshot: queryDocumentSnapshots) {
                  if (documentSnapshot != null) {
                      restaurants.add(documentSnapshot.toObject(Restaurant.class));
                  }

              }
          }
      });


       // final TextView textView = root.findViewById(R.id.text_home);
      //  String test = "Monday-Breakfast-8-10-Lunch-11-2-Dinner-6-8(5),Saturday-Breakfast-8-10-Lunch-11-2-Dinner-0-0";
        //Map<String, String> map = new HashMap<>();
        // map.put("test",test);
        //FirebaseFirestore.getInstance().collection("Restaurants").document("Wiley").set(map);
       // FirebaseFirestore.getInstance().collection("Restaurants").addSnapshotListener(new EventListener<QuerySnapshot>() {
        //                                                                                  @Override
         //                                                                                 public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
          //                                                                                    if (error == null) {
          //                                                                                        for (DocumentSnapshot d : queryDocumentSnapshots) {
           //                                                                                           retrievedValue = d.get("test").toString();
            //                                                                                          parseString(retrievedValue);
             //                                                                                     }
             //                                                                                 }
              //                                                                            }
              //                                                                        }
        //);
        return root;
    }

}