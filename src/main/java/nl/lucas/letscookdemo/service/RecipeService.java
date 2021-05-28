package nl.lucas.letscookdemo.service;

import nl.lucas.letscookdemo.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipes();
    Recipe getRecipe(long id);
    Recipe addRecipe(Recipe recipe);
    void updateRecipe(long id, Recipe recipe);
    void removeRecipe(long id);
}
