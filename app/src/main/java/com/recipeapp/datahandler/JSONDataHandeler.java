package main.java.com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.java.com.recipeapp.ui.Recipe;

public class JSONDataHandeler extends DataHandler{

        @Override
    // 文字列CSVを返してください。
    public String getMode(){
        return "JSON";
    }

    @Override
    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    public ArrayList<Recipe> readData() throws IOException{
            ArrayList<String> data = new ArrayList<>();
                try(BufferedReader reader = new BufferedReader(new FileReader("app/src/main/resources/recipes.json"))){
                    String line;
                    while((line = reader.readLine()) != null){
                        System.out.println(line);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
        if(data == reader.readLine()){
            return "No recipes available.";
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

    @Override
    // 以降の設問で処理を実装するため定義のみ行います。
    public void writeData(Recipe recipe) throws IOException{
            RecipeFileHandler handler = new RecipeFileHandler();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter recipe name:  ");
        String recipeName = reader.readLine();
        System.out.print("Enter main ingredients (comma separated): ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String ingredients = reader.readLine();
        handler.addRecipe(recipeName,ingredients);
        
    }

    @Override
    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    public ArrayList<Recipe> searchData(String keyword) throws IOException{
        return null;
    }
}
