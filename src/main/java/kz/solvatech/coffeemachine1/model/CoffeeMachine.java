package kz.solvatech.coffeemachine1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coffee_machine")
public class CoffeeMachine {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "coffeemachine_recipe",
            joinColumns = @JoinColumn(name = "coffeemachine_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe> recipes = new HashSet<>();

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void setId(Long id) {
        this.id = id;
    }

}