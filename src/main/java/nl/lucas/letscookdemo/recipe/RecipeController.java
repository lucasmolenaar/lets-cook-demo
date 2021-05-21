package nl.lucas.letscookdemo.recipe;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private List<Recipe> recipes;

    //Contructor
    public RecipeController() {
        this.recipes = new ArrayList<>();
    }

    @GetMapping
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @PostMapping
    public void addRecipe(@RequestBody Recipe recipe) {
        recipes.add(recipe);
    }

    @DeleteMapping("{id}")
    public void deleteRecipe(@PathVariable("id") int id) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getId() == id) {
                recipes.remove(i);
            }
        }
    }
}
