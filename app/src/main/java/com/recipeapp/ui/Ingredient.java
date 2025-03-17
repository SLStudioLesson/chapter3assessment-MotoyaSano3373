import com.recipeapp.ui;


import java.util.ArrayList;

public class Ingredient {
        // 材料の名前
    private String name;

    public Ingredient(String name){
        // nameフィールドに、同名の引数を代入する
        this.name = name;
    }

    public String getName(){
        // nameフィールドを返す
        return name;
    }
    
}
