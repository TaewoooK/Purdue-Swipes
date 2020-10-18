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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.purdue.helloworld.RestaurantAdapter;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    String retrievedValue;
ArrayList<Restaurant> restaurants = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
         recyclerView = root.findViewById(R.id.rvHome);
        //name,description,location,time,drawablepath,takeMealSwipes,OnlyMealSwipes
        /*
        Restaurant aadr = new Restaurant("All American Dining Room", "The All American Dining Room - NEW THIS YEAR - FEATURING 1bowl, is another grab-and-go meal swipe option located in Cary Quadrangle offering a rotating assortment of specialty entrée bowls. Choose a hot or cold entreé bowl made to order with a fountain beverage.", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.aadr_time), "allamerican",true, true);
        Restaurant peteza = new Restaurant("Pete's Za", "Pete's Za at Meredith is a grab and go meal swipe option that serves a veriety of hot and ready pizza", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.peteza_time), "petesza", true,true);
        Restaurant onebowl = new Restaurant("1Bowl", "1bowl @ Meredith is a grab-and-go swipe meal plan option, available only for meal plan holders, located in 1North of the Gathering Place at Meredith Hall, featuring a rotating menu of specialty entrée bowls. Choose a hot or cold entreé bowl made to order with a fountain beverage.", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.onebowl_time),"onebowl", true, true);
        Restaurant caryKnightSpot = new Restaurant("Cary Knight Spot", "Open late to satisfy all your pub grub cravings- stop by for burgers, fries, quesadillas, tenders, and more. Located in the basement of Cary Quad South.","https://www.google.com/maps/place/Cary+Knight+Spot+Grill/@40.4317733,-86.9193086,17z/data=!3m1!4b1!4m5!3m4!1s0x8812fd4ca6441cb5:0x3be521b18709d11!8m2!3d40.4317692!4d-86.9171199",getString(R.string.caryknightspot_time),"caryknightspot",true,false);

        CollectionReference d =FirebaseFirestore.getInstance().collection("Restaurants");
        d.add(aadr);
        d.add(peteza);
        d.add(onebowl);
        d.add(caryKnightSpot);

*/

/*
        Restaurant panera = new Restaurant("Panera Bread", "The company operates as Saint Louis Bread Company in the Greater St. Louis area, where it has over 100 locations. Offerings include bakery items, pasta, salads, sandwiches, soups, and specialty drinks.", "https://www.google.com/maps/place/Panera+Bread/@40.4228822,-86.9263825,15z/data=!4m8!1m2!2m1!1spanera!3m4!1s0x8812e37e1fd73ac5:0xc9d3acfdc4c66eb0!8m2!3d40.425488!4d-86.92268", getString(R.string.panera_time), "panera", true, false);
        Restaurant qdoba = new Restaurant("Qdoba", "Qdoba Mexican Eats is a chain of fast casual restaurants in the United States and Canada serving Mexican-style cuisine", "https://www.google.com/maps/place/QDOBA+Mexican+Eats/@40.4228502,-86.9263825,15z/data=!4m8!1m2!2m1!1sqdoba!3m4!1s0x8812e3cb41790565:0x16b270e6149d3109!8m2!3d40.4256215!4d-86.9224247", getString(R.string.qdoba_time), "qdoba", true, false);
        Restaurant chickFilA = new Restaurant("Chick Fil A", "Chick-fil-A is one of the largest American fast food restaurant chains and the largest whose specialty is chicken sandwiches", "https://www.google.com/maps/place/Chick-fil-A/@40.4229903,-86.9526471,13z/data=!4m8!1m2!2m1!1schick-fil-a!3m4!1s0x8812e322e59ee1ff:0x5a54ae845029c1e5!8m2!3d40.428475!4d-86.919535", getString(R.string.chickfila_time), "chickfila", true, false);
        Restaurant jerseyMikes = new Restaurant("Jersey Mike's", "Jersey Mike's Subs is an American submarine sandwich chain headquartered in Wall Township, New Jersey. The Jersey Mike's franchise has almost 1,592 locations open and about 124 more in development across the United States, in addition to three locations in Queensland, Australia and two in Ontario, Canada", "https://www.google.com/maps/place/Purdue+University/@40.4285133,-86.9195129,21z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.jerseymikes_time), "jerseymikes", true, false);
        Restaurant harrisonGrill = new Restaurant("Harrison Grill", "Dive into a new experience with american food and allow Harrison Grill to bring you something exquisite. We have options for every member of the family to explore! We are located in West Lafayette, feel free to explore our restaurant menu!", "https://www.google.com/maps/place/Harrison+Grill/@40.4249477,-86.9287688,17z/data=!3m1!4b1!4m5!3m4!1s0x8812e2c94783e7e1:0x7d7efb55ef3fb8c2!8m2!3d40.4249436!4d-86.9265801", getString(R.string.harrisongrill_time), "harrisongrill", true, false);
        Restaurant cosi = new Restaurant("Cosi", "Così, based in Boston, Massachusetts, is an American fast-casual restaurant chain that is known for its homemade flatbread. The name comes from the opera Così fan tutte, which was a favorite of the original owner.", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.cosi_time), "cosi", true, false);
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
        final RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurants);
      FirebaseFirestore.getInstance().collection("Restaurants").addSnapshotListener(new EventListener<QuerySnapshot>() {
          @Override
          public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
              restaurants.clear();
              for (DocumentSnapshot documentSnapshot: queryDocumentSnapshots) {
                  if (documentSnapshot != null) {
                      Restaurant restaurant = documentSnapshot.toObject(Restaurant.class);
                      restaurants.add(restaurant);
                  }

              }
              restaurantAdapter.notifyDataSetChanged();
          }

      });
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(restaurantAdapter);

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