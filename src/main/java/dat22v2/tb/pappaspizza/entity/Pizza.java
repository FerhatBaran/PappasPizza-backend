package dat22v2.tb.pappaspizza.entity;
import dat22v2.tb.pappaspizza.service.IngredientService;
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
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int price;

    //@JsonIgnore

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Ingredient> ingredients;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void addIngredient(Ingredient ingredient){
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        this.ingredients.add(ingredient);
    }

    public Pizza(Pizza pizza){
        this.id = pizza.getId();
        this.ingredients = pizza.getIngredients();
        this.name = pizza.getName();
        this.price = pizza.getPrice();
    }


}
