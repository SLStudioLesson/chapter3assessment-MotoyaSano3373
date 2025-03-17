package main.java.com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import main.java.com.recipeapp.ui.Recipe;

public interface DateHandler {
    // 現在のモードを返します。
    public String getMode();

    // レシピデータを読み込み、Recipeオブジェクトのリストとして返します。
    public ArrayList<Recipe> readData() throws IOException;

    // 指定されたRecipeオブジェクトを追加します。
    public void writeData(Recipe recipe) throws IOException;

    // 指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返します。
    public ArrayList<Recipe> searchData(String keyword) throws IOException;
}
