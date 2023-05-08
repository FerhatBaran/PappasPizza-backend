package dat22v2.tb.pappaspizza.config;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DeveloperData implements ApplicationRunner {

    PizzaRepository pizzaRepository;

    OrderRepository orderRepository;

    public DeveloperData(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("tomat");
        ingredient1.setPrice(5.0);
        ingredient1.setId(1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("pølse");
        ingredient2.setPrice(8.0);
        ingredient2.setId(2);

        Pizza pizza1 = new Pizza();
        pizza1.setId(1);
        pizza1.setName("miav");
        pizza1.setPrice(65.5);
        pizza1.addIngredient(ingredient1);
        pizza1.addIngredient(ingredient2);

        Order order = new Order();
        order.setId(1);
        order.addPizza(pizza1);

        orderRepository.save(order);




    }
}
