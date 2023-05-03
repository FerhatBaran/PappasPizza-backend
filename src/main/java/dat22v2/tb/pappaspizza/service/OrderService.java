package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.IngredientResponse;
import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderResponses = orders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }

}
