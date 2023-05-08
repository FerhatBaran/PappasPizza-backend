package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.entity.CustomerOrder;
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
        List<CustomerOrder> customerOrders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderResponses = customerOrders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }

    public List<OrderResponse> getConfirmedOrders() {
        List<CustomerOrder> customerOrders = orderRepository.findAll();
        List<CustomerOrder> confirmedOrders = new ArrayList<>();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (CustomerOrder order : customerOrders ) {
            if (order.isConfirmed()){
                confirmedOrders.add(order);
            }

        }
        orderResponses = confirmedOrders.stream().map(order -> new OrderResponse(order)).toList();
        return orderResponses;
    }

    public void confirmOrder(Integer id) {
       CustomerOrder order = orderRepository.findById(id).orElseThrow(()
               -> new EntityNotFoundException("No such Order"));
       boolean value = !order.isConfirmed();
       order.setConfirmed(value);
       orderRepository.save(order);
    }

    public void changeStatus(Integer id, String newStatus) {
        CustomerOrder order = orderRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("No such Order"));
        order.setStatus(OrderStatus.valueOf(newStatus));
        orderRepository.save(order);
    }
}
