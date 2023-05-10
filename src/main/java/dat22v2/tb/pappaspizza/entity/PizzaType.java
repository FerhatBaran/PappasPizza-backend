package dat22v2.tb.pappaspizza.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class PizzaType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String size;
    Double price;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizzaType")
    List<Pizza> pizzas;


}
