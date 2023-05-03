package dat22v2.tb.pappaspizza.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Pizza;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private Integer id;

    private LocalDateTime creationDate;

    private List<Pizza> pizzas;

    private boolean confirmed;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.creationDate = order.getCreationDate();
        this.pizzas = order.getPizzas();
        this.confirmed = order.isConfirmed();
    }
}
