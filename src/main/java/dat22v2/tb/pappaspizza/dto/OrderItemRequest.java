package dat22v2.tb.pappaspizza.dto;


import dat22v2.tb.pappaspizza.entity.Consumable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemRequest {

    Integer pizzaId;
    Integer drinkId;
    Integer quantity;
    List<Integer> added;
    List<Integer> removed;


}
