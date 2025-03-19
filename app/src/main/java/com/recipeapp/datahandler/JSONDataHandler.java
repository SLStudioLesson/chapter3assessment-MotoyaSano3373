package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler {

    @Override
    // 文字列JSONを返してください。
    public String getMode() {
        return "JSON";
    }

    @Override
    // 処理の実装は行わないので定義し、nullをreturnしてください。
    public ArrayList<Recipe> readData() throws IOException {
        return null;
    }

    @Override
    // 処理の実装は行わないので定義のみ行います。
    public void writeData(Recipe recipe) throws IOException {
    }
    

    @Override
    // 処理の実装は行わないので定義し、nullをreturnしてください。
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
