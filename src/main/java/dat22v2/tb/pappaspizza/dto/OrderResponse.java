package dat22v2.tb.pappaspizza.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Pizza;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import dat22v2.tb.pappaspizza.entity.OrderStatus;

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
    private LocalDateTime creationDate;

    private List<Pizza> pizzas;

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
        this.pizzas = order.getPizzas();
        this.confirmed = order.isConfirmed();
        this.status = order.getStatus();
    }
}
