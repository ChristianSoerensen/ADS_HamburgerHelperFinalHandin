package com.example.hamburgerhelper.IngredientsSource;

class Ingredients {

    private int id;
    private String name;
    private String description;
    private int price;
    private int iconId;

    public Ingredients(int id, String name, String description, int price, int iconId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getIconId() {
        return iconId;
    }
}
