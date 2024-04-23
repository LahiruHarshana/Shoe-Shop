package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : L.H.J
 * @File: User
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-20, Saturday
 **/


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
@Builder
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

//    @OneToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;

    @Column(length = 50)
    private String username;

    @Column(length = 50)
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private UserRole role;

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

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Customer.class)
    List<Customer> customers;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Sale.class)
    List<Sale> sales;

    public enum UserRole {
        ADMIN,
        USER
    }

}
