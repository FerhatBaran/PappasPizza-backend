package dat22v2.tb.pappaspizza.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Pizza> pizzas = new ArrayList<>();

    private boolean confirmed;

}
