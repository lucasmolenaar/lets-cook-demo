package nl.lucas.letscookdemo.service;

import nl.lucas.letscookdemo.exception.RecordNotFoundException;
import nl.lucas.letscookdemo.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    List<Recipe> recipes = new ArrayList<>();

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public Recipe getRecipe(long id) {
        Recipe recipe = null;

        for (int i = 0; i < recipes.size(); i++) {
            if (id == recipes.get(i).getId()) {
                recipe = recipes.get(i);
            }
        }

        if (recipe == null) {
            throw new RecordNotFoundException("Recipe not found");
        } else {
            return recipe;
        }
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return recipe;
    }

    @Override
    public void updateRecipe(long id, Recipe updatedRecipe) {
        Recipe recipe = null;

        for (int i = 0; i < recipes.size(); i++) {
            if (id == recipes.get(i).getId()) {
                recipe = recipes.get(i);
            }
        }

        if (recipe == null) {
            throw new RecordNotFoundException("Recipe not found");
        } else {
            recipe.setName(updatedRecipe.getName());
            recipe.setCal(updatedRecipe.getCal());
        }
    }

    @Override
    public void removeRecipe(long id) {

    }
}












