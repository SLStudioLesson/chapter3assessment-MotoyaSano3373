package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.datahandler.DataHandler;

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


    private void displayRecipes(){
        RecipeFileHandler handler = new RecipeFileHandler();
        ArrayList<String> data = new ArrayList<>();
        data = handler.readRecipes();
        if(data.isEmpty()){
            System.out.println("No recipes available.");
            return;
        }
        String[] lists;
                    for(String datas : data){
                        lists = datas.split(",", 2);
                    System.out.println("-----------------------------------");
                    System.out.println("Recipe Name: " + lists[0]);
                    System.out.println("Main Ingredients: " + lists[1]);
            }
            System.out.println("-----------------------------------");
 
    }

    public void addNewRecipes(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(recipeName + "," + ingredients);
            writer.newLine();
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println("ファイル操作エラー: " + e.getMessage());
        }
    }
}
