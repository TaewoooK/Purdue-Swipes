package com.purdue.helloworld.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;
import com.purdue.helloworld.R;
import com.purdue.helloworld.Restaurant;

public class uploadData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_data);
        EditText editText = findViewById(R.id.one);
        EditText editText1 = findViewById(R.id.two);
        EditText editText2 = findViewById(R.id.thre);
        EditText editText3 = findViewById(R.id.four);
        EditText editText4 = findViewById(R.id.five);
        EditText editText5 = findViewById(R.id.menu);
        CheckBox checkBox = findViewById(R.id.checkBox);
        CheckBox checkBox1 = findViewById(R.id.checkBox2);
        Button button = findViewById(R.id.button2);
        final String name = editText.getText().toString().trim();
        final String description = editText1.getText().toString().trim();
        final String imagePath = editText2.getText().toString().trim();
        final String location = editText3.getText().toString().trim();
        final String time = editText4.getText().toString().trim();
        final String menu = editText5.getText().toString().trim();
        final Boolean check = checkBox.isChecked();
        final Boolean check1 = checkBox1.isChecked();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restaurant restaurant = new Restaurant(name,description,location,time,imagePath,check,check1,menu);
                //FirebaseFirestore.getInstance().collection("Restaurants").add(restaurant);
            }
        });

    }
}