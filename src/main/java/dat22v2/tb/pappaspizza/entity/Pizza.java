package dat22v2.tb.pappaspizza.entity;

import dat22v2.tb.pappaspizza.dto.PizzaResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Pizza{

    @Id
    private int id;
    private String name;
    private double price;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Ingredient> ingredients;
    // Constructors, getters, and setters
}
