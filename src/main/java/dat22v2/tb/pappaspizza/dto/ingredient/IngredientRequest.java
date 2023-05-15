package dat22v2.tb.pappaspizza.dto.ingredient;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientRequest {
    private String name;


    public static Ingredient getIngredientEntity(IngredientRequest ingredientRequest) {
        return Ingredient.builder()
            .name(ingredientRequest.getName())
            .build();
    }

}
