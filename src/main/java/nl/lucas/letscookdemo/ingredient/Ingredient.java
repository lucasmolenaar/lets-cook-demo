package nl.lucas.letscookdemo.ingredient;

public class Ingredient {
    private int id;
    private String name;
    private int weightInGrams;

    public Ingredient() {}

    public Ingredient(int id, String name, int weightInGrams) {
        this.id = id;
        this.name = name;
        this.weightInGrams = weightInGrams;
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

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }
}
