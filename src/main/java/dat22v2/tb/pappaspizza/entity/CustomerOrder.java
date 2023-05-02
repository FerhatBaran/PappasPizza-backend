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
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String phoneNumber;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "pizzaId")
    private List<Pizza> Pizzas;

    public CustomerOrder(String phoneNumber, List<Pizza> pizzas) {
        this.phoneNumber = phoneNumber;
        this.Pizzas = pizzas;
    }
}
