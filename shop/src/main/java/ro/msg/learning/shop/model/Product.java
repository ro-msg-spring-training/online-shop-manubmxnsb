package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Entity
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer productId;

    @NotNull(message = "Product Category's Id is mandatory and must be a number")
    @ManyToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    private ProductCategory productCategory;

    @NotNull(message = "Supplier's Id is mandatory and must be a number")
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplierId;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Price is mandatory and must be a number")
    private Float price;

    @NotNull(message = "Weight is mandatory and must be a number")
    private Double weight;

    @NotBlank(message = "Image url is mandatory")
    private String image_url;

    @OneToMany(mappedBy = "stockId")
    private List<Stock> Stock;

    @OneToMany(mappedBy = "orderId")
    private List<OrderDetail> OrderDetail;

    public Product(String name,
                   String description,
                   Float price,
                   Double weight,
                   ProductCategory productCategory,
                   Supplier supplier,
                   String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.productCategory = productCategory;
        this.supplierId = supplier;
        this.image_url = imageUrl;
    }

    public Product(int id,
                   String name,
                   String description,
                   Float price,
                   Double weight,
                   ProductCategory productCategory,
                   Supplier supplier,
                   String imageUrl) {
        this.productId = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.productCategory = productCategory;
        this.supplierId = supplier;
        this.image_url = imageUrl;
    }

    public Product(int id) {
        this.productId = id;
    }
}