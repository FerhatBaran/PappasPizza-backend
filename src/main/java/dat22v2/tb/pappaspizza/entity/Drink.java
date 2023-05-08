package dat22v2.tb.pappaspizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Drink {
    @Id
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
