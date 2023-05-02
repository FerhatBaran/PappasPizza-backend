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
public class Drink {
  private String brand;
  private String size;

  private double price;
  @Id
  private int id;

  // Constructors, getters, and setters
}

