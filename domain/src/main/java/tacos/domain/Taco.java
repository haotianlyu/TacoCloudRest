package tacos.domain;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@RestResource(rel="tacos", path="tacos")
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, message="Name must be at least 5 characters long")
    private String name;

    @Column(name="created_at")
    private Date createdAt;

    @ManyToMany(targetEntity=Ingredient.class)
    @NotNull(message="You must choose at least 1 ingredient")
    @JoinTable(name = "taco_ingredients",
        joinColumns = @JoinColumn(name = "taco_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

}
