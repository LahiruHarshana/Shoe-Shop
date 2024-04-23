package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author : L.H.J
 * @File: Inventory
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_desc")
    private String itemDesc;

    @Lob
    @Column(name = "item_picture")
    private String itemPicture;

    @Column(name = "category")
    private String category;

    @Column(name = "size")
    private Integer size;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "unit_price_sale")
    private Double unitPriceSale;

    @Column(name = "unit_price_buy")
    private Double unitPriceBuy;

    @Column(name = "expected_profit")
    private Double expectedProfit;

    @Column(name = "profit_margin")
    private Double profitMargin;

    @Column(name = "status")
    private String status;

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
}
