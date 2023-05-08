package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.OrderStatus;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
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
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderResponses = orders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }

    public List<OrderResponse> getConfirmedOrders() {
        List<Order> orders = orderRepository.findAll();
        List<Order> confirmedOrders = new ArrayList<>();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            if (order.isConfirmed()){
                confirmedOrders.add(order);
            }

        }
        orderResponses = confirmedOrders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }

    public void confirmOrder(Integer id) {
       Order order = orderRepository.findById(id).orElseThrow(()
               -> new EntityNotFoundException("Kunne ikke finde Order"));
       boolean value = !order.isConfirmed();
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
