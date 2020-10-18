package com.purdue.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.purdue.helloworld.R;
import com.purdue.helloworld.Restaurant;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyHolder>{

    List<Restaurant> places;

    public RestaurantAdapter(List<Restaurant> places) {
        this.places= places;
    }
    @Override
    public RestaurantAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_restaurant,parent,false);

        RestaurantAdapter.MyHolder myHolder = new RestaurantAdapter.MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(final RestaurantAdapter.MyHolder holder, final int position) {

        final Restaurant data = places.get(position);
      
holder.picture.setImageResource(Utility.getDrawableName(data.getTitleImageID()));

       // holder.picture.getResources().getDrawable(data.getDrawableID());

        holder.name.setText(data.getName());
        holder.description.setText(data.getDescription());
        //System.out.println(data.getDate_class2());
        final Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(holder.itemView.getContext(),RestaurantInfo.class);
            intent.putExtra("menu",data.getMenu());
            intent.putExtra("time",data.getTime());
            context.startActivity(intent);

            }
        });
        holder.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openMaps(data.getLocation(),holder.itemView.getContext());
            }
        });
    }
        @Override
        public int getItemCount() {
            return places.size();
        }


    class MyHolder extends RecyclerView.ViewHolder{
        ImageView picture;
        TextView name,description,nextTimeOpen;
        Button map;
        public MyHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
            nextTimeOpen = (TextView) itemView.findViewById(R.id.nextTimeOpen);
            map = itemView.findViewById(R.id.mapNavigate);

        }
    }




}

