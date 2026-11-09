package com.example.androidproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import model.Recipe;

public class RecipeDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName, tvCategory, tvIngredients, tvInstructions;
    TextView tvVegan, tvGlutenFree;

    Button btnReturn;

    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialize();
    }
    private void initialize() {

        tvName = findViewById(R.id.tv_name);
        tvCategory = findViewById(R.id.tv_category);
        tvIngredients = findViewById(R.id.tv_ingredients);
        tvInstructions = findViewById(R.id.tv_instructions);

        tvVegan = findViewById(R.id.tv_vegan);
        tvGlutenFree = findViewById(R.id.tv_gluten_free);

        btnReturn = findViewById(R.id.btn_return);

        btnReturn.setOnClickListener(this);

        recipe = (Recipe) getIntent().getSerializableExtra("recipe");

        if (recipe != null) {

            tvName.setText(recipe.getName());
            tvCategory.setText(recipe.getCategory());
            tvIngredients.setText(recipe.getIngredients());
            tvInstructions.setText(recipe.getInstructions());

            if (recipe.isVegan()) {
                tvVegan.setText("Vegan: Yes");
            }
            else {
                tvVegan.setText("Vegan: No");
            }

            if (recipe.isGlutenFree()) {
                tvGlutenFree.setText("Gluten-Free: Yes");
            }
            else {
                tvGlutenFree.setText("Gluten-Free: No");
            }
        }
    }
    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.btn_return) {
            finish();
        }
    }
}


