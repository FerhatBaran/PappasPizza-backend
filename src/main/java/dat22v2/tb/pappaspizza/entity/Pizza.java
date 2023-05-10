package dat22v2.tb.pappaspizza.entity;
import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@DiscriminatorColumn(name = "consumable_type")
public class Pizza extends Consumable{

    private String name;

    @ManyToOne
    private PizzaType pizzaType;


    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient){
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        this.ingredients.add(ingredient);
    }


}
