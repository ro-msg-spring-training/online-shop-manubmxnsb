package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @ManyToOne
    @JoinColumn(name = "ProductCategoryID")
    private ProductCategory productCategory;
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplierId;
    private String name;
    private String description;
    private Float price;
    private Double weight;
    private String image_url;
    @OneToMany(mappedBy = "stockId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stock> Stock;
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> OrderDetail;
}