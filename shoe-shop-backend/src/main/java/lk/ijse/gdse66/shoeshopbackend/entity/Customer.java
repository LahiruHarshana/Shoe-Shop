package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    @Column(name = "customer_id")
    private String customerCode;

    @Column(name = "customer_name")
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    @CreationTimestamp
    @Column(name = "create_date", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate;

    @Column(name = "create_by")
    private String createBy;

    @UpdateTimestamp
    @Column(name = "modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifyDate;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "is_active", columnDefinition = "TINYINT(1)")
    private boolean isActive;

    @OneToMany( mappedBy = "customer",fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Sale.class)
    private List<Sale> sales;
    enum Gender {
        MALE, FEMALE, OTHER
    }
    enum LoyaltyLevel {
        GOLD, SILVER, BRONZE, NEW
    }
}
