package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.CustomerOrder;
import dat22v2.tb.pappaspizza.entity.Pizza;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private Integer id;

    private String phoneNumber;

    private List<Pizza> pizzas;

    public OrderRequest(String phoneNumber, List<Pizza> pizzas){
        this.phoneNumber = phoneNumber;
        this.pizzas = pizzas;
    }

    public CustomerOrder getOrderEntity(OrderRequest orderRequest){
        return new CustomerOrder(orderRequest.getPhoneNumber(), orderRequest.getPizzas());
    }
}
