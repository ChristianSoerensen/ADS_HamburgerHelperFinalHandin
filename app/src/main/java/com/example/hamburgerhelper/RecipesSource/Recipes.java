package com.example.hamburgerhelper.RecipesSource;

public class Recipes {
    private String name;
    private String description;
    private int iconID;

    Recipes(){

    }

    Recipes(String name, String description, int iconID){
        this.name = name;
        this.iconID = iconID;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIconId() {
        return iconID;
    }
}

