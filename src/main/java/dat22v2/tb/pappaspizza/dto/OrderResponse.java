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
public class OrderResponse {

    private Integer id;

    private String phoneNumber;

    private List<Pizza> pizzas;

    public OrderResponse(CustomerOrder customerOrder){
        this.id = customerOrder.getOrderId();
        this.phoneNumber = customerOrder.getPhoneNumber();
        this.pizzas = customerOrder.getPizzas();
    }
}
