package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeshopbackend.embedded.Address;
import lk.ijse.gdse66.shoeshopbackend.enums.Gender;
import lk.ijse.gdse66.shoeshopbackend.enums.Level;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author : L.H.J
 * @File: Customer
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-20, Saturday
 **/

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @CreationTimestamp
    private Timestamp registeredDate;
    private Integer totalPoints;
    @Column(unique = true)
    private String contact;
    private String email;
    private java.sql.Date recentPurchaseDate;
    private Address address;
    @Enumerated(EnumType.STRING)
    private Level level;
    private Date dob;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Sale> sales;
}
