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
    Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    LocalDateTime creationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderItem> orderItems;

    String phoneNumber;

    String name;

    String address;

    String postalCode;

    LocalDateTime pickUpTime;

    Boolean confirmed;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('FRESH','IN_PROGRESS','READY','DELIVERED')")
    private OrderStatus status;



    public static Order getOrderEntity(OrderRequest orderRequest) {
        return Order.builder()
            .phoneNumber(orderRequest.getPhoneNumber())
            .name(orderRequest.getName())
            .address(orderRequest.getAddress())
            .postalCode(orderRequest.getPostalCode())
            .pickUpTime(orderRequest.getPickUpTime())
            .confirmed(false)
            .build();

    }
}
