package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.OrderItem;
import dat22v2.tb.pappaspizza.entity.OrderStatus;
import dat22v2.tb.pappaspizza.entity.Pizza;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {

    private Integer id;

    private String phoneNumber;

    private List<OrderItemRequest> orderItems;

    private String name;
    private String address;
    private String postalCode;
    private LocalDateTime pickUpTime;

    private boolean confirmed;
    private OrderStatus status;



}
