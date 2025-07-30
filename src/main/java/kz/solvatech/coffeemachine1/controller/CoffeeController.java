package kz.solvatech.coffeemachine1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kz.solvatech.coffeemachine1.service.CoffeeService;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CoffeeController {

    @Autowired
    private CoffeeService service;

    @PostMapping("/make")
    public ResponseEntity<?> makeDrink(@RequestParam Long machineId,
                                       @RequestParam String recipeName) {
        return service.makeDrink(machineId, recipeName);
    }

    @GetMapping("/popular")
    public ResponseEntity<?> getPopular() {
        String popular = service.getMostPopularRecipe();
        return ResponseEntity.ok(Map.of("popular", popular));
    }
}
