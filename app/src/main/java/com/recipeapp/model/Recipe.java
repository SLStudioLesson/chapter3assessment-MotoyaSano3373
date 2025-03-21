package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    // レシピの名前
    private String name;
    // レシピの材料リスト
    private ArrayList<Ingredient> ingredients;
    public int length;

    public Recipe(String name, ArrayList<Ingredient> ingredients){
        // nameフィールドとingredientsフィールドそれぞれに、同名の引数を代入する
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName(){
        // nameフィールドを返す
        return name;
    }

    public ArrayList<Ingredient> getIngredients(){
        // ingredientsフィールドを返す
        return ingredients;
    }

}
