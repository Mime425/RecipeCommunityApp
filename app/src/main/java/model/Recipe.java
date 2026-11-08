package model;

public class Recipe  {
    private int id;
    private String name;
    private String ingredients;
    private String instructions;
    private String category;
    private String username;
    private boolean vegan;
    private boolean glutenFree;

    public Recipe(String name, String ingredients,
                  String instructions, String category,
                  boolean vegan, boolean glutenFree) {

        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category='" + category + '\'' +
                ", username='" + username + '\'' +
                ", vegan=" + vegan +
                ", glutenFree=" + glutenFree +
                '}';
    }
}