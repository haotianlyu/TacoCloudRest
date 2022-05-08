package tacos.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {
    private final static long  serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "place_at")
    private Date placeAt;

    @ManyToOne
    private User user;


}
