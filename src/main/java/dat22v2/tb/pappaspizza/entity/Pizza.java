package dat22v2.tb.pappaspizza.entity;

import dat22v2.tb.pappaspizza.dto.PizzaResponse;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

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
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> ingredients;
    // Constructors, getters, and setters
}
