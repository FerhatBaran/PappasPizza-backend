package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.IngredientResponse;
import dat22v2.tb.pappaspizza.dto.OrderItemRequest;
import dat22v2.tb.pappaspizza.dto.OrderRequest;
import dat22v2.tb.pappaspizza.entity.*;
import dat22v2.tb.pappaspizza.repository.*;
import dat22v2.tb.pappaspizza.dto.OrderResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    PizzaRepository pizzaRepository;

    IngredientRepository ingredientRepository;

    ConsumableRepository consumableRepository;
    DrinkRepository drinkRepository;

    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository, IngredientRepository ingredientRepository, ConsumableRepository consumableRepository, DrinkRepository drinkRepository) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.consumableRepository = consumableRepository;
        this.drinkRepository = drinkRepository;
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderResponses = orders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }


    public OrderResponse addOrder(OrderRequest orderRequest) {
        Order order = Order.getOrderEntity(orderRequest);
        order.setOrderItems(
            orderRequest.getOrderItems().stream().map(this::getOrderItem).toList()
        );
        order.getOrderItems().forEach(e -> e.setOrder(order));

        OrderResponse orderResponse = new OrderResponse(orderRepository.save(order));
        return orderResponse;
    }

    private OrderItem getOrderItem(OrderItemRequest orderItemRequest) {
        OrderItem orderItem = new OrderItem();
        if (orderItemRequest.getPizzaId() != null) {
            orderItem.setConsumable(pizzaRepository.findById(orderItemRequest.getPizzaId()).orElseThrow(() -> new EntityNotFoundException("test pizza")));
        }
        if (orderItemRequest.getDrinkId() != null) {
            orderItem.setConsumable(drinkRepository.findById(orderItemRequest.getDrinkId()).orElseThrow(() -> new EntityNotFoundException("test drink")));
        }
        orderItem.setQuantity(orderItemRequest.getQuantity());

        if (orderItemRequest.getAdded() != null) {
            orderItem.setAdded(ingredientRepository.findByIdIn(orderItemRequest.getAdded()));

        }
        if (orderItemRequest.getRemoved() != null) {
            orderItem.setRemoved(ingredientRepository.findByIdIn(orderItemRequest.getRemoved()));

        }
        return orderItem;
    }



/*
    public OrderResponse addOrder(OrderRequest body) {

        body.setPizzas(checkForCustomPizzas(body)); //Sets the list of pizzas to the corrected pricing and custom pizzas.

        Order order = orderRepository.save( new OrderRequest().getOrderEntity(body));
        return new OrderResponse(order);
    }
* */
/*
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
* */

    public List<OrderResponse> getConfirmedOrders() {
        List<Order> orders = orderRepository.findAll();
        List<Order> confirmedOrders = new ArrayList<>();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            if (order.getConfirmed()){
                confirmedOrders.add(order);
            }

        }
        orderResponses = confirmedOrders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }

    public void confirmOrder(Integer id) {
       Order order = orderRepository.findById(id).orElseThrow(()
               -> new EntityNotFoundException("Kunne ikke finde Order"));
       boolean value = !order.getConfirmed();
       order.setConfirmed(value);
       orderRepository.save(order);
    }

    public void changeStatus(Integer id, String newStatus) {
        Order order = orderRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Kunne ikke finde Order"));
        order.setStatus(OrderStatus.valueOf(newStatus));
        orderRepository.save(order);
    }
}
