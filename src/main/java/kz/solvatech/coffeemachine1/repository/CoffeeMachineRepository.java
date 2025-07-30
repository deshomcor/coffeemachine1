package kz.solvatech.coffeemachine1.repository;

import kz.solvatech.coffeemachine1.model.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Long> {}
