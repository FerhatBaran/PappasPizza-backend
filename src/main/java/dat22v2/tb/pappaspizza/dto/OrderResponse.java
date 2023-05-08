package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.CustomerOrder;
import dat22v2.tb.pappaspizza.entity.OrderStatus;
import dat22v2.tb.pappaspizza.entity.Pizza;
import lombok.*;

import java.time.LocalDateTime;
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

    private String name;
    private String address;
    private int postalCode;
    private LocalDateTime pickUpTime;

    private boolean confirmed;
    private OrderStatus status;

    public OrderResponse(CustomerOrder customerOrder){
        this.id = customerOrder.getOrderId();
        this.phoneNumber = customerOrder.getPhoneNumber();
        this.name = customerOrder.getName();
        this.address = customerOrder.getAddress();
        this.postalCode = customerOrder.getPostalCode();
        this.pickUpTime = customerOrder.getPickUpTime();
        this.pizzas = customerOrder.getPizzas();
        this.confirmed = customerOrder.isConfirmed();
        this.status = customerOrder.getStatus();
    }
}
