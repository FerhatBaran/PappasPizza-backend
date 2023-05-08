package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.IngredientResponse;
import dat22v2.tb.pappaspizza.dto.OrderRequest;
import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    PizzaRepository pizzaRepository;

    IngredientRepository ingredientRepository;

    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository, IngredientRepository ingredientRepository) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    final int IDFORCUSTOMPIZZA = 80;

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderResponses = orders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }

    public OrderResponse addOrder(OrderRequest body) {

        body.setPizzas(checkForCustomPizzas(body)); //Sets the list of pizzas to the corrected pricing and custom pizzas.

        Order order = orderRepository.save(OrderRequest.getOrderEntity(body));
        return new OrderResponse(order);
    }

    private List<Pizza> checkForCustomPizzas(OrderRequest body) {

        List<Pizza> pizzas = body.getPizzas();

        //checking if there are pizzas on the list, that have different ingredients from their base pizza.
        boolean customPizzaFound = false;
        boolean customIngredientFound = false;
        for (Pizza pizza : pizzas) {

            //Need boolean to check if the pizza is custom, it is reset for every pizza.
            customPizzaFound = false;

            //Initializing the custom pizza from the pizza that was sent through body.
            Pizza newCustomPizza = new Pizza(pizza);
            //newCustomPizza.setId(IDFORCUSTOMPIZZA);
            newCustomPizza.setName("BrugerDefineret " + newCustomPizza.getName());

            //Initialising the lists of the pizza that is from the database, and the one that was sent in.
            List<Ingredient> ingredientsFromPizzaOrder = new ArrayList<>(pizza.getIngredients());
            List<Ingredient> ingredientsFromPizzaList = new ArrayList<>(pizzaRepository.findById(pizza.getId()).get().getIngredients());

            //if(ingredientsFromPizzaOrder.size() > ingredientsFromPizzaList.size()){}

            for (Ingredient ingredientOrder : ingredientsFromPizzaOrder) {
                customIngredientFound = true;
                //If ingredient doesn't exist in the Pizza, it will be added to the custom pizza, and the price will go up as well.
                for(Ingredient ingredientList : ingredientsFromPizzaList) {

                    boolean ingredientExistsById = ingredientList.getId() == ingredientOrder.getId();

                    if (ingredientExistsById) {
                        customIngredientFound = false;
                    }
                }
                    if (customIngredientFound) {
                        newCustomPizza.setPrice(newCustomPizza.getPrice() + ingredientOrder.getPrice());
                        customPizzaFound = true;
                    }

            }
            if (customPizzaFound) {
                pizzas.remove(pizza);
                pizzas.add(newCustomPizza);
            }

        }
        return pizzas;
    }
}
