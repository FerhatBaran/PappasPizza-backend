package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Order;
import lombok.*;
import dat22v2.tb.pappaspizza.entity.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private Integer id;
    private String phoneNumber;
    private LocalDateTime creationDate;

    private List<PizzaResponse> pizzas;
    private List<DrinkResponse> drinks;

    private String name;
    private String address;
    private int postalCode;
    private LocalDateTime pickUpTime;

    private boolean confirmed;
    private OrderStatus status;

    public OrderResponse(Order order){
        this.id = order.getId();
        this.phoneNumber = order.getPhoneNumber();
        this.name = order.getName();
        this.address = order.getAddress();
        this.creationDate = order.getCreationDate();
        this.postalCode = order.getPostalCode();
        this.pickUpTime = order.getPickUpTime();
        this.pizzas = order.getPizzas().stream().map(PizzaResponse::new).collect(Collectors.toList());
        this.drinks = order.getDrinks().stream().map(DrinkResponse::new).collect(Collectors.toList());
        this.confirmed = order.isConfirmed();
        this.status = order.getStatus();
    }
}
