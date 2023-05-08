package dat22v2.tb.pappaspizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ingredient {

  @Id
  private Integer id;
  private String name;
  private double price;


  // Constructors, getters, and setters
}
