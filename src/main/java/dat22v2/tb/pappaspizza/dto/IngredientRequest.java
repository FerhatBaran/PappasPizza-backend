package dat22v2.tb.pappaspizza.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientRequest {
    private String name;

    private int price;

}
