package com.example.hamburgerhelper.RecipesSource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hamburgerhelper.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecipeWriter extends AppCompatActivity {

    EditText nameInput;
    EditText descriptionInput;
    Button sendButton;
    Toolbar toolbarWL;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("recipes");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_writer);

        //code for Toolbar
        toolbarWL = (Toolbar) findViewById(R.id.recipesWriter_toolbar);
        setSupportActionBar(toolbarWL);

        toolbarWL.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(RecipeWriter.this, RecipeList.class);
                startActivity(backIntent);
            }
        });

        nameInput = (EditText) findViewById(R.id.titlePut);
        descriptionInput = (EditText) findViewById(R.id.descriptionPut);
        sendButton = (Button) findViewById(R.id.addRecipe);

        sendButton.setOnClickListener(saveAndReturn);


    }

    View.OnClickListener saveAndReturn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = nameInput.getText().toString();
            String dec = descriptionInput.getText().toString() ;
            int picID = R.drawable.p1;
            Recipes recipe = new Recipes(name,dec,picID);
            myRef.push().setValue(recipe);
            //returns to list
            Intent intent = new Intent(RecipeWriter.this, RecipeList.class);
            startActivity(intent);
            Toast toast = (Toast) Toast.makeText(getApplicationContext(), "Recipe is saved", Toast.LENGTH_SHORT);
            toast.show();
        }
    };
}
