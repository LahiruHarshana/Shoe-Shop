package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : L.H.J
 * @File: Sale
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "item_desc")
    private String itemDesc;

    @Column(name = "size")
    private Integer size;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "item_qty")
    private Integer itemQty;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "added_points")
    private Double addedPoints;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "cashier_name")
    private String cashierName;

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

    @OneToMany(mappedBy = "sale",fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = SaleDetails.class)
    List<SaleDetailsDTO> saleDetails = new ArrayList<>();
}
