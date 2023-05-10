package dat22v2.tb.pappaspizza.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorColumn(name = "consumable_type")
public class Drink extends Consumable{

    String brand;

    @ManyToOne
    private DrinkType drinkType;

}
