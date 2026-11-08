package com.example.androidproject;
import com.google.android.material.snackbar.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import model.Recipe;
import android.content.Intent;

public class AddRecipeActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edName, edIngredients, edInstructions;
    RadioGroup rgCategory;
    CheckBox cbVegan, cbGlutenFree;
    Button btnSave, btnShow;
    public static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_recipe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialize();
    }

    private void initialize() {
        edName = findViewById(R.id.ed_name);
        edIngredients = findViewById(R.id.ed_ingredients);
        edInstructions = findViewById(R.id.ed_instructions);
        rgCategory = findViewById(R.id.rg_category);
        cbVegan = findViewById(R.id.cb_vegan);
        cbGlutenFree = findViewById(R.id.cb_gluten_free);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);
        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_save) {
            saveRecipe(view);
        }
        if (id == R.id.btn_show) {
            showAllRecipes();
        }
    }

    private void saveRecipe(View view) {
        try {
            String name = edName.getText().toString();
            String ingredients = edIngredients.getText().toString();
            String instructions = edInstructions.getText().toString();
            String category = "";
            int rbChecked = rgCategory.getCheckedRadioButtonId();
            if (rbChecked == R.id.rb_breakfast)
                category = "Breakfast";
            if (rbChecked == R.id.rb_lunch)
                category = "Lunch";
            if (rbChecked == R.id.rb_dinner)
                category = "Dinner";

            boolean vegan = cbVegan.isChecked();
            boolean glutenFree = cbGlutenFree.isChecked();
            if (name.trim().isEmpty() || ingredients.trim().isEmpty()
                    || instructions.trim().isEmpty() || category.isEmpty()) {
                Snackbar.make(view, "Please complete all fields",
                        Snackbar.LENGTH_LONG).show();
                return;
            }

            Recipe recipe = new Recipe(name, ingredients,
                    instructions, category, vegan, glutenFree);
            recipeList.add(recipe);

            Snackbar.make(view, "Recipe added successfully!",
                    Snackbar.LENGTH_LONG).show();
            clearWidgets();

        } catch (Exception e) {
            Snackbar.make(view, e.getMessage(),
                    Snackbar.LENGTH_LONG).show();
        }
    }

    private void showAllRecipes() {

        Intent intent = new Intent(this, RecipeListActivity.class);
        startActivity(intent);
    }

    private void clearWidgets() {
        edName.setText(null);
        edIngredients.setText(null);
        edInstructions.setText(null);
        rgCategory.clearCheck();
        cbVegan.setChecked(false);
        cbGlutenFree.setChecked(false);
    }
}