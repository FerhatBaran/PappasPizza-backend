package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Consumable;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.OrderItem;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class OrderItemResponse {

    int id;
    Consumable consumable;
    int quantity;
    List<IngredientResponse> added;
    List<IngredientResponse> removed;


    public OrderItemResponse(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.consumable = orderItem.getConsumable();
        this.quantity = orderItem.getQuantity();
        if (orderItem.getAdded() != null) {
            this.added = orderItem.getAdded().stream().map(IngredientResponse::new).toList();
        }
        if (orderItem.getRemoved() != null) {
            this.removed = orderItem.getRemoved().stream().map(IngredientResponse::new).toList();
        }

    }
}
