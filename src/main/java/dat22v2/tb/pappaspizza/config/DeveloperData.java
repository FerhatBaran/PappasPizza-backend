package dat22v2.tb.pappaspizza.config;

import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.OrderStatus;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

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

        Order order1 = Order.builder().phoneNumber("12345678")
                .name("bob")
                .address("test")
                .postalCode(2000)
                .pickUpTime(LocalDateTime.of(2020,10,23,5,5,5))
                .confirmed(false)
                .status(OrderStatus.FRESH)
                .build();
        Order order2 = Order.builder().phoneNumber("87654321")
                .name("lise")
                .address("test2")
                .postalCode(2000)
                .pickUpTime(LocalDateTime.of(2020,10,23,5,5,5))
                .confirmed(true)
                .status(OrderStatus.IN_PROGRESS)
                .build();

        orderRepository.save(order1);
        orderRepository.save(order2);

    }



}
