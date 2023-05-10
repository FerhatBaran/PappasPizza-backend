package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.DrinkType;

public class DrinkTypeResponse {

    String size;
    Double price;

    public DrinkTypeResponse(DrinkType drinkType) {
        this.size = drinkType.getSize();
        this.price = drinkType.getPrice();

    }
}
