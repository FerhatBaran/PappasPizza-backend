package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Pizza;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PizzaResponse {

    String name;
    Double price;

    List<IngredientResponse> ingredients;




    public PizzaResponse(Pizza pizza) {
        this.name = pizza.getName();
        this.price = pizza.getPrice();
        this.ingredients = pizza.getIngredients().stream().map(IngredientResponse::new).collect(Collectors.toList());

    }
}
