package dat22v2.tb.pappaspizza.entity;


import dat22v2.tb.pappaspizza.dto.OrderResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Order {
    @Id
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @ManyToMany
    List<Pizza> pizzas;


    @ManyToMany
    List<Drink> drinks;





}
