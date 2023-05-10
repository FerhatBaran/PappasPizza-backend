package dat22v2.tb.pappaspizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class DrinkType {
    @Id
    private int id;

    private String size;

    private Double price;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drinkType")
    List<Drink> drinks;

}
