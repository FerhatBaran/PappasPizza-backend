package dat22v2.tb.pappaspizza.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Receipt {
    @Id
    private int id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @OneToOne(cascade = CascadeType.MERGE)
    Order order;
}
