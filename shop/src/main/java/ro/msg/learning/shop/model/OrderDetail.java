package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "OrderId")
    private PlacedOrder orderId;
    private Integer quantity;
}