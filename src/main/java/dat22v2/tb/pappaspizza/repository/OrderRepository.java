package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Integer> {

}
