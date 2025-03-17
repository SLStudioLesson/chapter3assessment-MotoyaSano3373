package main.java.com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.java.com.recipeapp.ui.Recipe;

    public class CSVDataHandler implements DataHandler{
    // レシピデータを格納するCSVファイルのパス。
    private String filepath;

    // フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
    public CSVDataHandler(){
        this.filepath = "app/src/main/resources/recipes.csv";
    }

    // フィールドfilePathに引数を代入する
    public CSVDataHandler(String filepath){
        this.filepath = filepath;
    }

    @Override
    // 文字列CSVを返してください。
    public String getMode(){
        return "CSV";
    }

    @Override
    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    public ArrayList<Recipe> readData() throws IOException{
        return null;
            }

    @Override
    // 以降の設問で処理を実装するため定義のみ行います。
    public void writeData(Recipe recipe) throws IOException{
}
    }

