package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Drink;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DrinkResponse {

    String brand;

    String size;

    Double price;


    public DrinkResponse(Drink drink) {
        this.brand = drink.getBrand();
        this.size = drink.getSize();
        this.price = drink.getPrice();
    }
}
