package ro.msg.learning.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Entity
@Table(name="placed_order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlacedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Customer's Id is mandatory and must be a number")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @NotNull(message = "Customer's Id is mandatory and must be a number")
    @ManyToOne
    @JoinColumn(name = "shipped_from_id")
    private Location location;

    //TODO: Checkout auto insert of localDate
    @PastOrPresent(message = "Time of order is mandatory")
    private LocalDate created_at;

    @Column(name="ADDRESS_COUNTRY")
    @NotBlank(message = "Country field is mandatory")
    private String country;

    @Column(name="ADDRESS_CITY")
    @NotBlank(message = "City field is mandatory")
    private String city;

    @Column(name="ADDRESS_COUNTY")
    @NotBlank(message = "County field is mandatory")
    private String county;

    @Column(name="ADDRESS_STREET")
    @NotBlank(message = "Street Address field is mandatory")
    private String addressStreet;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "orderId")
    private List<OrderDetail> orderDetails;
}