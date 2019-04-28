package com.example.hamburgerhelper.IngredientsSource;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.hamburgerhelper.MainActivity;
import com.example.hamburgerhelper.R;
import com.example.hamburgerhelper.SQLdatabase.IngredientsContract;
import com.example.hamburgerhelper.SQLdatabase.IngredientsDBHelper;

import java.util.ArrayList;

public class IngredientsList extends AppCompatActivity {

    Toolbar toolbarRL;

    RecyclerView mIngredientsList;
    RecyclerView.Adapter mIngredientsListAdapter;

    IngredientsDBHelper ingredientsDBHelper = new IngredientsDBHelper(this);


    private ArrayList<Ingredients> ingredientsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_list);

        //code for Toolbar
        toolbarRL = (Toolbar) findViewById(R.id.ingredientsList_toolbar);
        setSupportActionBar(toolbarRL);

        toolbarRL.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(IngredientsList.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
        //code for recycler view
        mIngredientsList = findViewById(R.id.in_rv);
        mIngredientsList.hasFixedSize();
        mIngredientsList.setLayoutManager(new LinearLayoutManager(this));

        databaseReader();
        /*
        if(ingredientsArrayList.get(0) == null){
            Ingredients dummy = new Ingredients(-1, "Dummy", "dummy", 0, R.drawable.p1);
            ingredientsArrayList.add(dummy);
        }*/

        mIngredientsListAdapter = new IngredientsListAdapter(ingredientsArrayList);
        mIngredientsList.setAdapter(mIngredientsListAdapter);

    };
    //code for options in toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.newIngredient:
                Intent intent = new Intent(IngredientsList.this, IngredientsWriter.class);
                startActivity(intent);


            case R.id.removeAll:
                SQLiteDatabase db = ingredientsDBHelper.getWritableDatabase();
                db.execSQL("DROP TABLE IF EXISTS " + IngredientsContract.IngredientEntry.TABLE_NAME);
               /*ingredientsArrayList = new ArrayList<>();
                databaseReader();
                mIngredientsListAdapter.notifyDataSetChanged();
                mIngredientsList.setAdapter(mIngredientsListAdapter);*/


            default: return super.onOptionsItemSelected(item);
        }
    }
    //Inflates the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ingredient_list_menu, menu);
        return true;
    };
    //Reads from database and inserts to the arraylist.
    private void databaseReader(){
        //IngredientsDBHelper ingredientsDBHelper = new IngredientsDBHelper(this);
        SQLiteDatabase db = ingredientsDBHelper.getReadableDatabase();

        String[] projection = {
                IngredientsContract.IngredientEntry._ID,
                IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_NAME,
                IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_DESCRIPTION,
                IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_PRICE,
                IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_ICONID,
        };

        Cursor cursor = db.query(IngredientsContract.IngredientEntry.TABLE_NAME,projection,
                null,
                null,
                null,
                null,
                null);
        try{


        int idColumnIndex = cursor.getColumnIndex(IngredientsContract.IngredientEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_NAME);
        int descriptionColumnIndex = cursor.getColumnIndex(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_DESCRIPTION);
        int priceColumnIndex = cursor.getColumnIndex(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_PRICE);
        int iconIdColumnIndex = cursor.getColumnIndex(IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_ICONID);

        while(cursor.moveToNext()) {

            int currentID = cursor.getInt(idColumnIndex);
            String currentName = cursor.getString(nameColumnIndex);
            String currentDescription = cursor.getColumnName(descriptionColumnIndex);
            int currentPrice = cursor.getInt(priceColumnIndex);
            int currentIconID = cursor.getInt(iconIdColumnIndex);

            Ingredients ingredients = new Ingredients(currentID, currentName, currentDescription,currentPrice,currentIconID);
            ingredientsArrayList.add(ingredients);
        }

        }finally {
            cursor.close();
        }

    }


}
