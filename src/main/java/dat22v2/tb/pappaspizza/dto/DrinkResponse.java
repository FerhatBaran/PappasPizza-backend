package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Drink;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrinkResponse {

    Integer id;

    String brand;

    DrinkTypeResponse drinkTypeResponse;


    public DrinkResponse(Drink drink) {
        this.id = drink.getId();
        this.brand = drink.getBrand();
        this.drinkTypeResponse = new DrinkTypeResponse(drink.getDrinkType());
    }
}
