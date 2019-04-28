package com.example.hamburgerhelper.RestaurantsSource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hamburgerhelper.JsonWebReader.FetchJson;
import com.example.hamburgerhelper.MainActivity;
import com.example.hamburgerhelper.R;

public class RestaurantsList extends AppCompatActivity {

    Toolbar toolbarRL;
    Button getButton;
    public static TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes_list);

        showText = (TextView) findViewById(R.id.rl_preview);


        //code for Toolbar
        toolbarRL = (Toolbar) findViewById(R.id.restaurantsList_toolbar);
        setSupportActionBar(toolbarRL);

        toolbarRL.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(RestaurantsList.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
        makeList();

    }
    public void makeList(){
           FetchJson process = new FetchJson();
           process.execute();

    };

}
