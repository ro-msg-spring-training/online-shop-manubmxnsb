package ro.msg.learning.shop.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastLame;
    private String username;
    private String password;
    private String email_Address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlacedOrder> orders;
}