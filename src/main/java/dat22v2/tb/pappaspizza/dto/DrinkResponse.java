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

    String size;

    Double price;


    public DrinkResponse(Drink drink) {
        this.brand = drink.getBrand();
        this.size = drink.getSize();
        this.price = drink.getPrice();
        this.id = drink.getId();

    }
}
