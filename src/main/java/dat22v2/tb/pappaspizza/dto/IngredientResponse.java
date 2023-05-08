package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class IngredientResponse {

    String name;
    Double price;

    public IngredientResponse(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.price = ingredient.getPrice();
    }
}
