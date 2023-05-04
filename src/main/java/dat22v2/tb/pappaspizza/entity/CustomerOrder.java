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
    private List<Pizza> pizzas;

    private boolean confirmed;

    public CustomerOrder(String phoneNumber, List<Pizza> pizzas, boolean confirmed) {
        this.phoneNumber = phoneNumber;
        this.pizzas = pizzas;
        this.confirmed = confirmed;
    }
}
