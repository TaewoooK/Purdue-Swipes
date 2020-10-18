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
        Restaurant freshens = new Restaurant("Freshens", "Freshëns Fresh Food Studio is a healthy fresh casual concept, which offers prepared to order food inspired by fresh ingredients, as well as our signature fresh blended smoothies and frozen yogurt.", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.freshens_time), "freshens", true, false);
        Restaurant aubonpain = new Restaurant("Au Bon Pain", "Au Bon Pain is an American fast casual restaurant, bakery, and café chain headquartered in Boston and operating over 250 locations in the United States, India, and Thailand.", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.aubonpain_time), "aubonpain", true, false);
        Restaurant sushiboss = new Restaurant("Sushi Boss", "Sushi Boss is an innovative sushi concept that features local, fresh, and natural ingredients. Every roll is made fresh before your eyes with the ingredients you select, so you can be as creative as you like or choose from our signature sushi menu. The sushi is fresh, flavorful, creative and fast - try some today!", "https://www.google.com/maps/place/Purdue+University/@40.4276951,-86.9216452,17z/data=!4m5!3m4!1s0x8812fd37423e0507:0x8eccb2cf8b1a7c8e!8m2!3d40.4237054!4d-86.9211946", getString(R.string.sushiboss_time), "sushiboss", true, true);;
        Restaurant earhart = new Restaurant("Earhart Dining Hall", "Earhart Hall is one of the sixteen residential halls within Purdue University, located on 1275 First Street facing First Street Tower and behind Shreve Hall. It is officially named after the famous aviator Amelia Earhart.", "https://www.google.com/maps/place/Earhart+Dining+Hall/@40.4256237,-86.927107,17z/data=!3m1!4b1!4m5!3m4!1s0x8812e2c97f2d5ad5:0xf63bf92ca936aefe!8m2!3d40.4256196!4d-86.9249183", getString(R.string.earhart_time), "earhart", true, true);
        Restaurant hillenbrand = new Restaurant("Hillenbrand Dining Hall", "Welcome to Hillenbrand Hall, which has been at the forefront of new and exciting University Residences programs for 25 years. Hillenbrand Hall's unique design blends the best features of contemporary and traditional designs in order to provide a comfortable, quiet, and relaxed atmosphere.", "https://www.google.com/maps/place/Hillenbrand+Residence+Hall,+1301+3rd+Street,+West+Lafayette,+IN+47906/@40.4266793,-86.9288857,17z/data=!3m1!4b1!4m5!3m4!1s0x8812e2cbe4b788ad:0x5cf00d1c29ed17e6!8m2!3d40.4266752!4d-86.926697", getString(R.string.hillenbrand_time), "Hillenbrand", true, true);
        Restaurant windsor = new Restaurant("Windsor Dining Hall", "Welcome to Windsor Halls! Consisting of five distinct buildings – Duhme, Shealy, Warren, Wood, and Vawter, this 748-bed, all-women’s residence hall complex was built between the years of 1934 to 1951.", "https://www.google.com/maps/place/Windsor+Dining+Court/@40.4265667,-86.9235024,17z/data=!3m1!4b1!4m5!3m4!1s0x8812e2b5c166c8cb:0xc6b89b5c96b567c4!8m2!3d40.4265626!4d-86.9213137", getString(R.string.windsor_time), "windsor", true, true);
        Restaurant wiley = new Restaurant("Wiley Dining Hall", "Welcome to Wiley Hall, which brings student leaders from all levels together to connect, engage and succeed on campus! Wiley Hall opened in 1958 and was named for Harvey W. Wiley, born on October 18, 1844.", "https://www.google.com/maps/place/Wiley+Dining+Court/@40.4285251,-86.9230122,17z/data=!3m1!4b1!4m5!3m4!1s0x8812e2b15807a209:0x561f5eb85d8c5a66!8m2!3d40.428521!4d-86.9208235", getString(R.string.wiley_time), "wiley", true, true);
        Restaurant ford = new Restaurant("Ford Dining Hall", "Welcome to Cary Quad, one of the largest all-male residence halls in the country! Consisting of five buildings, Cary Quad is one of the oldest residence halls on campus. Cary East opened in 1928, Northeast in 1931, Northwest and West in 1938, and finally, South in 1939", "https://www.google.com/maps/place/Ford+Dining+Court/@40.432113,-86.9217461,17z/data=!3m1!4b1!4m5!3m4!1s0x8812fd4b26db4177:0x2f3f9ae6b45d3924!8m2!3d40.4321089!4d-86.9195574", getString(R.string.ford_time), "ford", true, true);
        Restaurant otgford = new Restaurant("Ford On The Go", "On-the-GO! (OTG) is one of your carry-out options for dining. Located adjacent to Earhart, Ford and Windsor Dining Courts and locations at Knoy and Lilly halls and Port in Lawson Computer Science Building.", "https://www.google.com/maps/place/Ford+Dining+Court/@40.432113,-86.9217461,17z/data=!3m1!4b1!4m5!3m4!1s0x8812fd4b26db4177:0x2f3f9ae6b45d3924!8m2!3d40.4321089!4d-86.9195574", getString(R.string.otgford_time), "otgford", true, true);
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