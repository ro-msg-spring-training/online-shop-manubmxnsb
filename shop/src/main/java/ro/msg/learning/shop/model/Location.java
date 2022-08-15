package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Builder
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
    @Column(name="id")
    private Integer id;
    private String name;
    @Column(name="ADDRESS_COUNTRY")
    private String country;
    @Column(name="ADDRESS_CITY")
    private String city;
    @Column(name="ADDRESS_COUNTY")
    private String county;
    @Column(name="ADDRESS_STREET")
    private String streetAdress;
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlacedOrder> orders;
    @OneToMany(mappedBy = "stockId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stock> stocks;
    public Location(String locationName, String country, String city, String county, String street) {
        this.name = locationName;
        this.country = country;
        this.city = city;
        this.county = county;
        this.streetAdress = street;
    }
}