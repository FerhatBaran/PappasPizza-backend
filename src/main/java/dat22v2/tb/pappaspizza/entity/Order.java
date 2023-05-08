package dat22v2.tb.pappaspizza.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat22v2.tb.pappaspizza.dto.OrderRequest;
import org.hibernate.annotations.CreationTimestamp;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDateTime creationDate;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Pizza> pizzas = new ArrayList<>();

    private String phoneNumber;
    
    private String name;

    private String address;

    private int postalCode;

    private LocalDateTime pickUpTime;

    private boolean confirmed;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('FRESH','IN_PROGRESS','READY','DELIVERED')")
    private OrderStatus status;

    public Order(String phoneNumber, List<Pizza> pizzas, String name, String address,
                 int postalCode, LocalDateTime pickUpTime, boolean confirmed,
                 OrderStatus status) {
        this.phoneNumber = phoneNumber;
        this.pizzas = pizzas;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.pickUpTime = pickUpTime;
        this.confirmed = confirmed;
        this.status = status;
    }
}
