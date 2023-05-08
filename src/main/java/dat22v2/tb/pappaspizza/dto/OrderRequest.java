package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Order;
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
    private List<Pizza> pizzas;
    private boolean confirmed;

    public static Order getOrderEntity(OrderRequest body) {
        Order order = Order.builder()
                .creationDate(LocalDateTime.now())
                .pizzas(body.getPizzas())
                .confirmed(body.isConfirmed())
                .build();

        return order;

    }

}