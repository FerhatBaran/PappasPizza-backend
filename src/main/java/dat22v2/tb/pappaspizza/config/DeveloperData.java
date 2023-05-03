package dat22v2.tb.pappaspizza.config;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
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

        //Pizza

        Pizza margherita = new Pizza();
        margherita.setName("Margherita");
        margherita.setPrice(10);
        margherita.getIngredients().add(cheese);
        margherita.getIngredients().add(tomatoSauce);

        Pizza pepperoniPizza = new Pizza();
        pepperoniPizza.setName("Pepperoni");
        pepperoniPizza.setPrice(12);
        pepperoniPizza.getIngredients().add(cheese);
        pepperoniPizza.getIngredients().add(tomatoSauce);
        pepperoniPizza.getIngredients().add(pepperoni);

        Pizza hawaiian = new Pizza();
        hawaiian.setName("Hawaiian");
        hawaiian.setPrice(12);
        hawaiian.getIngredients().add(cheese);
        hawaiian.getIngredients().add(tomatoSauce);
        hawaiian.getIngredients().add(ham);
        hawaiian.getIngredients().add(pineapple);

        //Orders

        Order order1 = new Order();
        order1.setCreationDate(LocalDateTime.now());
        order1.setConfirmed(false);
        order1.getPizzas().add(margherita);
        order1.getPizzas().add(pepperoniPizza);

        Order order2 = new Order();
        order2.setCreationDate(LocalDateTime.now());
        order2.setConfirmed(false);
        order2.getPizzas().add(hawaiian);
        order2.getPizzas().add(pepperoniPizza);

        pizzaRepository.save(margherita);
        pizzaRepository.save(pepperoniPizza);
        pizzaRepository.save(hawaiian);

        orderRepository.save(order1);
        orderRepository.save(order2);


    }
}
