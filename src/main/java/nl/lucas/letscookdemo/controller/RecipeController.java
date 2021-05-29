package nl.lucas.letscookdemo.controller;

import nl.lucas.letscookdemo.model.Recipe;
import nl.lucas.letscookdemo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<Object> getRecipes() {
        return ResponseEntity.ok().body(recipeService.getRecipes());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getRecipe(@PathVariable("id") long id) {
        Recipe recipe = recipeService.getRecipe(id);
        return ResponseEntity.ok().body(recipe);
    }

    @PostMapping
    public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateRecipe(@PathVariable("id") long id, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(id, recipe);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> removeRecipe(@PathVariable("id") long id) {
        recipeService.removeRecipe(id);
        return ResponseEntity.noContent().build();
    }
}
