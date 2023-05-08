package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Drink;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Pizza;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {


    List<PizzaResponse> pizzas;


    List<DrinkResponse> drinks;

    LocalDateTime created;

    Boolean confirmed;

    LocalDateTime deliveryTime;





    public OrderResponse(Order order) {
        this.pizzas = order.getPizzas().stream().map(PizzaResponse::new).collect(Collectors.toList());
        this.drinks = order.getDrinks().stream().map(DrinkResponse::new).collect(Collectors.toList());
        this.created = order.getCreated();
        this.confirmed = order.getConfirmed();
        this.deliveryTime = order.getDeliveryTime();



    }

}
