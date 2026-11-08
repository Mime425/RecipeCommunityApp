package com.example.androidproject;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import model.Recipe;


public class RecipeListActivity extends AppCompatActivity implements View.OnClickListener {
    ListView lvRecipes;
    TextView tvTotal;
    Button btnReturn;
    ArrayList<Recipe> recipeList;
    ArrayAdapter<Recipe> recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();
    }
    private void initialize() {
        lvRecipes = findViewById(R.id.lv_recipes);
        tvTotal = findViewById(R.id.tv_total);
        btnReturn = findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(this);

        recipeList = AddRecipeActivity.recipeList;
        recipeAdapter = new ArrayAdapter<Recipe>(this,
                R.layout.recipe_item, recipeList);
        lvRecipes.setAdapter(recipeAdapter);
        tvTotal.setText("Total Recipes: " + recipeList.size());
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_return) {
            finish();
        }
    }
}