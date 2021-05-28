package nl.lucas.letscookdemo.controller;

import nl.lucas.letscookdemo.model.Recipe;
import nl.lucas.letscookdemo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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






////    @DeleteMapping("{id}")
////    public void deleteRecipe(@PathVariable("id") int id) {
////        for (int i = 0; i < recipes.size(); i++) {
////            if (recipes.get(i).getId() == id) {
////                recipes.remove(i);
////            }
////        }
////    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
//        recipes.remove(id);
//        return ResponseEntity.noContent().build();
//    }
}
