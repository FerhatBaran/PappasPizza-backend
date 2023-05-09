package dat22v2.tb.pappaspizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Drink {

    @Id
    private int id;

    String brand;

    String size;

    Double price;
}
