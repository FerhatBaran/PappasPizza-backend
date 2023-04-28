package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PizzaRepository extends JpaRepository<Pizza,Integer>, JpaSpecificationExecutor<Pizza> {
}