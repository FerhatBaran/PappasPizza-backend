package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.entity.CustomerOrder;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    PizzaRepository pizzaRepository;
    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public List<OrderResponse> getOrders(){
        List<CustomerOrder> customerOrders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderResponses = customerOrders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }
}
