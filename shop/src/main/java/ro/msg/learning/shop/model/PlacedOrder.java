package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlacedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location locationId;
    private Timestamp created_at;
    private String country;
    private String city;
    private String county;
    private String streetAdress;
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> OrderDetails;
}