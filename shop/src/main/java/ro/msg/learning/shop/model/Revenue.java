package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="Revenue")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="LOCATION_ID")
    private Integer location_ID;
    @Column(name="DATE_D")
    private Date date;
    private Double sum;
}
