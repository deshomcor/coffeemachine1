package kz.solvatech.coffeemachine1.repository;

import kz.solvatech.coffeemachine1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o.recipe.recipename AS name, COUNT(o) AS count FROM Order o GROUP BY o.recipe.recipename ORDER BY count DESC")
    List<Map<String, Object>> findPopularRecipes();
}
