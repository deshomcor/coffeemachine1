package kz.solvatech.coffeemachine1.service;

import kz.solvatech.coffeemachine1.model.CoffeeMachine;
import kz.solvatech.coffeemachine1.model.Order;
import kz.solvatech.coffeemachine1.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import kz.solvatech.coffeemachine1.repository.CoffeeMachineRepository;
import kz.solvatech.coffeemachine1.repository.OrderRepository;
import kz.solvatech.coffeemachine1.repository.RecipeRepository;

import java.time.LocalDateTime;

@Service
public class CoffeeService {

    @Autowired private RecipeRepository recipeRepo;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired private CoffeeMachineRepository machineRepo;

    public ResponseEntity<?> makeDrink(Long machineId, String recipeName) {
        CoffeeMachine machine = machineRepo.findById(machineId)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        Recipe recipe = recipeRepo.findByRecipename(recipeName)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        if (!machine.getRecipes().contains(recipe)) {
            return ResponseEntity.status(403).body("This machine does not support the selected recipe.");
        }

        Order order = new Order();
        order.setRecipe(recipe);
        order.setDate(LocalDateTime.now());
        orderRepo.save(order);

        return ResponseEntity.ok("Drink prepared: " + recipe.getRecipename());
    }

    public String getMostPopularRecipe() {
        var list = orderRepo.findPopularRecipes();
        return list.isEmpty() ? null : (String) list.get(0).get("name");
    }
}
