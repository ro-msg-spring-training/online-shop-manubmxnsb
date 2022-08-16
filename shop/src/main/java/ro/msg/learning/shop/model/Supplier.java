package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Entity
@Table(name="Supplier")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String name;
    @Size(min=1)
    @OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> product;
    public Supplier(String name) {
        this.name = name;
    }
}