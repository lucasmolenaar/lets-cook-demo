package nl.lucas.letscookdemo.ingredient;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private List<Ingredient> ingredients;

    public IngredientController() {
        ingredients = new ArrayList<>();
    }

    @GetMapping
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @PostMapping
    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable("id") int id) {
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getId() == id) {
                ingredients.remove(i);
            }
        }
    }
}
