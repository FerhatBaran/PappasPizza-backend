package dat22v2.tb.pappaspizza.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ingredient {


    @Id
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    String name;
    Double price;

}
