package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Pizza;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PizzaResponse {

    private int id;
    private String name;
    private double price;
    private List<String> ingredients;


    public PizzaResponse(Pizza pizza) {
    this.id = pizza.getId();
    this.name = pizza.getName();
    this.price = pizza.getPrice();
    this.ingredients = pizza.getIngredients();
    }
}
