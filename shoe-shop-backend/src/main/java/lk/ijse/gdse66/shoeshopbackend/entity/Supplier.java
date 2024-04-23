package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : L.H.J
 * @File: Supplier
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Entity
@Table(name = "supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @Column(name = "supplier_code", unique = true)
    private String supplierCode;

    @Column(name = "supplier_name")
    private String supplierName;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private SupplierCategory category;

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

    @Column(name = "address_line_06")
    private String addressLine6;

    @Column(name = "contact_no1")
    private String contactNo1;

    @Column(name = "contact_no2")
    private String contactNo2;

    @Column(name = "email")
    private String email;

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

    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Inventory.class)
    List<Inventory> inventories;
    public enum SupplierCategory {
        INTERNATIONAL, LOCAL
    }
}