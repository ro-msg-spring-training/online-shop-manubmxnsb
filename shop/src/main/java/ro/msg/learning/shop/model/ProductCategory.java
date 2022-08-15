package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Entity
@Table(name ="product_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    private String description;

    @Size(min=1)
    @OneToMany(mappedBy = "productId", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> Product;

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

}