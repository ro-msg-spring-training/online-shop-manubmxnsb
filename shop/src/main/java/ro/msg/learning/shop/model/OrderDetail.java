package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="order_detail")
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
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private PlacedOrder orderId;
    private Integer quantity;
}