package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockId;
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location locationId;
    private Integer quantity;
}