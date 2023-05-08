package dat22v2.tb.pappaspizza.config;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;

import dat22v2.tb.pappaspizza.entity.OrderStatus;

import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.config.ScheduledTaskHolder;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class DeveloperData implements ApplicationRunner {

    IngredientRepository ingredientRepository;
    OrderRepository orderRepository;
    PizzaRepository pizzaRepository;

    public DeveloperData(IngredientRepository ingredientRepository, OrderRepository orderRepository, PizzaRepository pizzaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //Ingredients.

        Ingredient cheese = new Ingredient();
        cheese.setName("Cheese");
        cheese.setPrice(2);

        Ingredient tomatoSauce = new Ingredient();
        tomatoSauce.setName("Tomato Sauce");
        tomatoSauce.setPrice(1);

        Ingredient pepperoni = new Ingredient();
        pepperoni.setName("Pepperoni");
        pepperoni.setPrice(3);

        Ingredient mushrooms = new Ingredient();
        mushrooms.setName("Mushrooms");
        mushrooms.setPrice(2);

        Ingredient olives = new Ingredient();
        olives.setName("Olives");
        olives.setPrice(1);

        Ingredient onions = new Ingredient();
        onions.setName("Onions");
        onions.setPrice(1);

        Ingredient bacon = new Ingredient();
        bacon.setName("Bacon");
        bacon.setPrice(3);

        Ingredient sausage = new Ingredient();
        sausage.setName("Sausage");
        sausage.setPrice(3);

        Ingredient greenPeppers = new Ingredient();
        greenPeppers.setName("Green Peppers");
        greenPeppers.setPrice(1);

        Ingredient ham = new Ingredient();
        ham.setName("Ham");
        ham.setPrice(3);

        Ingredient pineapple = new Ingredient();
        pineapple.setName("Pineapple");
        pineapple.setPrice(2);

        ingredientRepository.save(cheese);
        ingredientRepository.save(tomatoSauce);
        ingredientRepository.save(pepperoni);
        ingredientRepository.save(mushrooms);
        ingredientRepository.save(olives);
        ingredientRepository.save(onions);
        ingredientRepository.save(bacon);
        ingredientRepository.save(sausage);
        ingredientRepository.save(greenPeppers);
        ingredientRepository.save(ham);
        ingredientRepository.save(pineapple);
        /*
        * */

        //Pizza

        Pizza margherita = new Pizza();
        margherita.setName("Margherita");
        margherita.setPrice(10);
        margherita.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        margherita.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));

        pizzaRepository.save(margherita);

        Pizza pepperoniPizza = new Pizza();
        pepperoniPizza.setName("Napoli");
        pepperoniPizza.setPrice(12);
        pepperoniPizza.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        pepperoniPizza.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));
        pepperoniPizza.addIngredient(ingredientRepository.findById(3).orElseThrow(() -> new EntityNotFoundException("pubad")));

        pizzaRepository.save(pepperoniPizza);

        Pizza hawaiian = new Pizza();
        hawaiian.setName("Hawaiian");
        hawaiian.setPrice(12);
        hawaiian.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        hawaiian.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));
        hawaiian.addIngredient(ingredientRepository.findById(10).orElseThrow(() -> new EntityNotFoundException("pubad")));
        hawaiian.addIngredient(ingredientRepository.findById(11).orElseThrow(() -> new EntityNotFoundException("pubad")));
        pizzaRepository.save(hawaiian);

        Pizza custom = new Pizza();
        custom.setId(80);
        custom.setName("Custom Pizza");
        custom.setPrice(10);
        custom.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        custom.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));

        pizzaRepository.save(custom);

        //Orders


        Order order1 = Order.builder().phoneNumber("12345678")
            .name("bob")
            .creationDate(LocalDateTime.now())
            .address("test")
            .postalCode(2000)
            .pickUpTime(LocalDateTime.of(2020,10,23,5,5,5))
            .confirmed(false)
            .status(OrderStatus.FRESH)
            .build();


        order1.addPizza(pizzaRepository.findById(1));
        order1.addPizza(pizzaRepository.findById(2));
        orderRepository.save(order1);


        Order order2 = Order.builder().phoneNumber("87654321")
            .name("lise")
            .address("test2")
            .creationDate(LocalDateTime.now())
            .postalCode(2000)
            .pickUpTime(LocalDateTime.of(2020,10,23,5,5,5))
            .confirmed(true)
            .status(OrderStatus.IN_PROGRESS)
            .build();


        order2.addPizza(pizzaRepository.findById(3));
        order2.addPizza(pizzaRepository.findById(4));
        orderRepository.save(order2);

/*
* */




    }
}
