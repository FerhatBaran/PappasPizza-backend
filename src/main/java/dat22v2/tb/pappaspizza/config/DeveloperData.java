package dat22v2.tb.pappaspizza.config;

import dat22v2.tb.pappaspizza.entity.CustomerOrder;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DeveloperData implements ApplicationRunner {

    OrderRepository orderRepository;
    PizzaRepository pizzaRepository;

    public DeveloperData(OrderRepository orderRepository, PizzaRepository pizzaRepository){
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        CustomerOrder customerOrder1 = CustomerOrder.builder().phoneNumber("12345678")
                .confirmed(false).build();
        CustomerOrder customerOrder2 = CustomerOrder.builder().phoneNumber("87654321")
                .confirmed(true).build();

        orderRepository.save(customerOrder1);
        orderRepository.save(customerOrder2);

    }



}
