package nl.lucas.letscookdemo.model;

public class Ingredient {
    private int id;
    private String name;

    public Ingredient() {}

    public Ingredient(int id, String name, int weightInGrams) {
        this.id = id;
        this.name = name;
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
}
