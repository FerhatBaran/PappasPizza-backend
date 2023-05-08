package dat22v2.tb.pappaspizza.entity;

import dat22v2.tb.pappaspizza.dto.PizzaResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Pizza {
    @Id
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    String name;
    String price;


    @ManyToMany
    List<Ingredient> ingredients;



}
