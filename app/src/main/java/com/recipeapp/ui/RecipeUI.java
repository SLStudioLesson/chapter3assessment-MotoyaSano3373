package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipes();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        // DateHandlerから読み込んだレシピデータを整形してコンソールに表示します
        try {
            ArrayList<Recipe> data = dataHandler.readData();
            if (data.isEmpty()) {
                System.out.println("No recipes available.");
                return;
            }
            System.out.println("Recipes :");
            for (Recipe datas : data) {
                System.out.println("-----------------------------------");
                System.out.println("Recipe Name: " + datas.getName());
                System.out.println("Main Ingredients: ");
                for (Ingredient ingredientRecipe : datas.getIngredients()) {
                    System.out.println(ingredientRecipe.getName());
                }

            }
            System.out.println("-----------------------------------");
            // IOExceptionを受け取った場合はError reading file: 例外のメッセージとコンソールに表示します
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewRecipes() {
        try {
            CSVDataHandler handler = new CSVDataHandler();
            System.out.println("Adding a new recipe.");
            System.out.print("Enter recipe name:  ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String recipeName = reader.readLine();
            String ingredientInput;
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            System.out.println("Enter ingredients (type 'done' when finished):");
            while (true) {
                System.out.print("Ingredient: ");
                ingredientInput = reader.readLine();
                if (ingredientInput.equals("done")) {
                    break;
                }
                Ingredient ingredient = new Ingredient(ingredientInput);
                ingredients.add(ingredient);
            }
            Recipe recipe = new Recipe(recipeName, ingredients);
            handler.writeData(recipe);
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}
