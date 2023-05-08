package dat22v2.tb.pappaspizza.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat22v2.tb.pappaspizza.dto.ReceiptResponse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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

    @CreationTimestamp
    LocalDateTime completed;











}
