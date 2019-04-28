package com.example.hamburgerhelper.SQLdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class IngredientsDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ingredients.db";
    private static final int DATABASE_VERSION = 1;

    public IngredientsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_INGREDIENTS_TABLE = "CREATE TABLE " + IngredientsContract.IngredientEntry.TABLE_NAME + "("
                + IngredientsContract.IngredientEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_NAME + " TEXT NOT NULL,"
                + IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_DESCRIPTION + " TEXT,"
                + IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_PRICE + " DOUBLE,"
                + IngredientsContract.IngredientEntry.COLUMN_INGREDIENT_ICONID + " TEXT);";
        db.execSQL(SQL_CREATE_INGREDIENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
