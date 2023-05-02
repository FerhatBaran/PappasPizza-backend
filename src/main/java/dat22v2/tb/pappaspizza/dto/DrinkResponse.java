package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Drink;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrinkResponse {
  private String brand;
  private String size;
  private double price;
  private int id;

  public DrinkResponse(Drink drink) {
    this.brand = drink.getBrand();
    this.size = drink.getSize();
    this.price = drink.getPrice();
    this.id = drink.getId();
  }
}
