package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAddRecipe,
            btnViewRecipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialize();
    }

    private void initialize() {
        btnAddRecipe = findViewById(R.id.btn_add_recipe);
        btnViewRecipes = findViewById(R.id.btn_view_recipes);
        btnAddRecipe.setOnClickListener(this);
        btnViewRecipes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_add_recipe) {
            Intent intent = new Intent(this, AddRecipeActivity.class);
            startActivity(intent);
        }
        if (id == R.id.btn_view_recipes) {
            Intent intent = new Intent(this, RecipeListActivity.class);
            startActivity(intent);
        }
    }
}