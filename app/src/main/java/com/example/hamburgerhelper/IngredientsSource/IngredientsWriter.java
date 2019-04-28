package com.example.hamburgerhelper.IngredientsSource;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hamburgerhelper.R;
import com.example.hamburgerhelper.SQLdatabase.IngredientsContract;
import com.example.hamburgerhelper.SQLdatabase.IngredientsDBHelper;

public class IngredientsWriter extends AppCompatActivity {

    private Toolbar toolbarWL;
    private EditText nameInput;
    private EditText descriptionInput;
    private EditText priceInput;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_writer);

        //code for Toolbar
        toolbarWL = (Toolbar) findViewById(R.id.ingredientsWriter_toolbar);
        setSupportActionBar(toolbarWL);

        toolbarWL.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(IngredientsWriter.this, IngredientsList.class);
                startActivity(backIntent);
            }
        });

        nameInput = (EditText) findViewById(R.id.titlePut_in);
        descriptionInput = (EditText) findViewById(R.id.descriptionPut_in);
        priceInput = (EditText) findViewById(R.id.pricePut_in);

        saveButton = (Button) findViewById(R.id.addIngredient_in);
        saveButton.setOnClickListener(saveToDB);
    }

    //Checks if the object is not empty.
    //and return to the list.
    View.OnClickListener saveToDB = new View.OnClickListener() {


        @Override
        public void onClick(View v) {

            String name = nameInput.getText().toString();
            String description = descriptionInput.getText().toString();
            String price = priceInput.getText().toString();
           if(!(name.isEmpty() && description.isEmpty())){
               insetToDb();
               Toast toast = (Toast) Toast.makeText(getBaseContext(), "Ingrediance has been saved", Toast.LENGTH_LONG);
               toast.show();
               Intent intent = new Intent(IngredientsWriter.this, IngredientsList.class);
               startActivity(intent);


           }
           else{
               Toast toast = (Toast) Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG);
               toast.show();
           }
        }
    };
    //for writing to the database.
    public void insetToDb(){
        IngredientsDBHelper mDatabase = new IngredientsDBHelper(this);
        SQLiteDatabase db = mDatabase.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_NAME, nameInput.getText().toString());
        values.put(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_DESCRIPTION, descriptionInput.getText().toString());
        values.put(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_PRICE, priceInput.getText().toString());
        values.put(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_ICONID, R.drawable.p1);

        db.insert(IngredientsContract.IngredientEntry.TABLE_NAME,null,values);

    }




}
