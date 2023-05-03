package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Pizza;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PizzaResponse {

    private Integer id;

    private String name;

    private int price;

    private List<Ingredient> ingredients;


    public PizzaResponse(Pizza pizza) {
        this.id = pizza.getId();
        this.name = pizza.getName();
        this.price = pizza.getPrice();
        this.ingredients = pizza.getIngredients();
    }
}
