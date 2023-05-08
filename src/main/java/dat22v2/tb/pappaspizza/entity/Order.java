package dat22v2.tb.pappaspizza.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import dat22v2.tb.pappaspizza.dto.OrderResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer_order")
public class Order {
    @Id
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    List<Pizza> pizzas;


    @ManyToMany(cascade = CascadeType.ALL)
    List<Drink> drinks;

    @CreationTimestamp
    LocalDateTime created;

    Boolean confirmed;


    LocalDateTime deliveryTime;


    public void addPizza(Pizza pizza) {
        if (pizzas == null) {
            pizzas = new ArrayList<>();
        }
        pizzas.add(pizza);
    }


    public void addDrink(Drink drink) {
        if (drinks == null) {
            drinks = new ArrayList<>();
        }
        drinks.add(drink);
    }




}
