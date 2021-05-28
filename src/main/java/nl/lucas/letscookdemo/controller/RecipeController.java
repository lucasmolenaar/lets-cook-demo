package nl.lucas.letscookdemo.controller;

import nl.lucas.letscookdemo.model.Recipe;
import org.springframework.http.ResponseEntity;
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
    public List<Recipe> getRecipes(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return recipes;
    }

    @GetMapping("{id}")
    public Recipe getRecipe(@PathVariable("id") int id) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getId() == id) {
                return recipes.get(i);
            }
        }
        return null;
    }

    @PostMapping
    public void addRecipe(@RequestBody Recipe recipe) {
        recipes.add(recipe);
    }

//    @DeleteMapping("{id}")
//    public void deleteRecipe(@PathVariable("id") int id) {
//        for (int i = 0; i < recipes.size(); i++) {
//            if (recipes.get(i).getId() == id) {
//                recipes.remove(i);
//            }
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        recipes.remove(id);
        return ResponseEntity.noContent().build();
    }
}
