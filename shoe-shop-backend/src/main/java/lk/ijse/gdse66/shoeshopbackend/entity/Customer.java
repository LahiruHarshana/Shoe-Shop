package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : L.H.J
 * @File: Customer
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-20, Saturday
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_name")
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "join_date")
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private LoyaltyLevel level;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "address_line_01")
    private String addressLine1;

    @Column(name = "address_line_02")
    private String addressLine2;

    @Column(name = "address_line_03")
    private String addressLine3;

    @Column(name = "address_line_04")
    private String addressLine4;

    @Column(name = "address_line_05")
    private String addressLine5;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "recent_purchase_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recentPurchaseDateTime;

    enum Gender {
        MALE, FEMALE, OTHER
    }

    enum LoyaltyLevel {
        GOLD, SILVER, BRONZE, NEW
    }
}
