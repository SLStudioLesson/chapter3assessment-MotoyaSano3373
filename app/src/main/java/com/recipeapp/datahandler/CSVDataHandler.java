package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;
import com.recipeapp.model.Ingredient;

public class CSVDataHandler implements DataHandler {
    // レシピデータを格納するCSVファイルのパス。
    private String filepath;

    // フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
    public CSVDataHandler() {
        this.filepath = "app/src/main/resources/recipes.csv";
    }

    // フィールドfilePathに引数を代入する
    public CSVDataHandler(String filepath) {
        this.filepath = filepath;
    }

    @Override
    // 文字列CSVを返してください。
    public String getMode() {
        return "CSV";
    }

    @Override
    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    public ArrayList<Recipe> readData() throws IOException {
        // recipes.csvからレシピデータを読み込み、それをリスト形式で返します
        ArrayList<Recipe> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] txt = line.split(",", 2);
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (int i = 1; i < txt.length; i++) {
                    ingredients.add(new Ingredient(txt[i]));
                }
                Recipe recipe = new Recipe(txt[0], ingredients);
                data.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return data;
    }

    @Override
    // 以降の設問で処理を実装するため定義のみ行います。
    public void writeData(Recipe recipe){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
            writer.write(recipe.getName());
            ArrayList<Ingredient> ingredients = recipe.getIngredients();
            for(int i = 0; i < ingredients.size(); i++){
                writer.write("," + ingredients.get(i).getName());
            }
            writer.newLine();
        } catch (IOException e) {
            System.out.println("ファイル操作エラー: " + e.getMessage());
        }

    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

}
