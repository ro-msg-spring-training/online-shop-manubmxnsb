package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String country;
    private String city;
    private String county;
    private String streetAdress;
    @OneToMany(mappedBy = "locationId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlacedOrder> orders;
    @OneToMany(mappedBy = "stockId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stock> stocks;
}