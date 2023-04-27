package dat22v2.tb.pappaspizza.entity;

import dat22v2.tb.pappaspizza.dto.PizzaResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


}
