package dat22v2.tb.pappaspizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Pizza {
    @Id
    private Integer id;

    @ManyToOne
    private Order order;


}
