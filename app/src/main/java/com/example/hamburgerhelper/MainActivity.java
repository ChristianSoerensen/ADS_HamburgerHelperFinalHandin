package com.example.hamburgerhelper;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.hamburgerhelper.IngredientsSource.IngredientsList;
import com.example.hamburgerhelper.RecipesSource.RecipeList;
import com.example.hamburgerhelper.RestaurantsSource.RestaurantsList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbarMain;
    Menu menu;
    Button homepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (Toolbar) findViewById(R.id.le_toolbar);
        setSupportActionBar(toolbarMain);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){

            case R.id.recipesList:
                intent = new Intent(MainActivity.this, RecipeList.class);
                startActivity(intent);
                return true;

            case R.id.ingredientsList:
                intent = new Intent(MainActivity.this, IngredientsList.class);
                startActivity(intent);
                return true;

            case R.id.restaurantsList:
                intent = new Intent(MainActivity.this, RestaurantsList.class);
                startActivity(intent);
                return true;

            case R.id.homePage:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nickpassey.com/wp-content/uploads/2016/10/Featured.jpg"));
                startActivity(intent);
                return true;

                default: return super.onOptionsItemSelected(item);
        }
    };

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
