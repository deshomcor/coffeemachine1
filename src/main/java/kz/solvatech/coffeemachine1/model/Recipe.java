package kz.solvatech.coffeemachine1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(unique = true)
    private String recipename;

    @ManyToMany(mappedBy = "recipes")
    private Set<CoffeeMachine> machines = new HashSet<>();

}