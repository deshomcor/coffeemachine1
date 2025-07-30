package kz.solvatech.coffeemachine1.repository;

import kz.solvatech.coffeemachine1.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByRecipename(String name);
}

