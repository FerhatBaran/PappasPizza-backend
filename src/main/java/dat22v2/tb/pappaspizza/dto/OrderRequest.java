package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Order;
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
public class OrderRequest {

    private Integer id;

    private String phoneNumber;

    private List<Pizza> pizzas;

    private String name;
    private String address;
    private int postalCode;
    private LocalDateTime pickUpTime;

    private boolean confirmed;
    private OrderStatus status;

    public OrderRequest(String phoneNumber, List<Pizza> pizzas, String name,
                        String address, int postalCode, LocalDateTime pickUpTime,
                        OrderStatus status, boolean confirmed){
        this.phoneNumber = phoneNumber;
        this.pizzas = pizzas;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.pickUpTime = pickUpTime;
        this.confirmed = confirmed;
        this.status = status;
    }

    public Order getOrderEntity(OrderRequest orderRequest){
        return new Order(orderRequest.getPhoneNumber(), orderRequest.getPizzas(),
                orderRequest.getName(), orderRequest.getAddress(),
                orderRequest.getPostalCode(), orderRequest.getPickUpTime(),
                orderRequest.isConfirmed(), orderRequest.getStatus());
    }
}
