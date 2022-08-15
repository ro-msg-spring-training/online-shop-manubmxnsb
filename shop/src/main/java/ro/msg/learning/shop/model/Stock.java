package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;

@Builder
@Entity
@Table(name="Stock")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer stockId;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;
    private Integer quantity;

    public Stock(Product product1, Location location1, int i) {
        this.product = product1;
        this.location = location1;
        this.stockId = i;
    }
}