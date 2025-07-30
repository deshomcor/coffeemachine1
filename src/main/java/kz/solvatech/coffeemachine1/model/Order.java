package kz.solvatech.coffeemachine1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"order\"") // "order" — зарезервированное слово в SQL
public class Order {

    // --- Геттеры и сеттеры ---
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @Getter
    @Setter
    private LocalDateTime date;  // <-- ВОТ ЭТО поле

    public void setId(Long id) {
        this.id = id;
    }

}
