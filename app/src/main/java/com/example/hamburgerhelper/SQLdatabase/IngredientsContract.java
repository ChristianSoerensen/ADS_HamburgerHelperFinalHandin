package com.example.hamburgerhelper.SQLdatabase;

import android.provider.BaseColumns;

public final class IngredientsContract {

    private IngredientsContract(){

    }
    public class IngredientEntry implements BaseColumns{
        public static final String TABLE_NAME = "ingredients";

        public static final String ID = BaseColumns._ID;
        public static final String COLUMN_INGREDIENT_NAME = "name";
        public static final String COLUMN_INGREDIENT_DESCRIPTION = "description";
        public static final String COLUMN_INGREDIENT_PRICE = "price";
        public static final String COLUMN_INGREDIENT_ICONID = "iconId";

    }

}
