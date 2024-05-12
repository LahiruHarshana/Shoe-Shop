package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemGender;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemStatus;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.function.SupplierUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : L.H.J
 * @File: Inventory
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    private String itemCode;
    private String itemDescription;
    private String itemPicture;
    private Integer qtyOnHand;
    private Integer size;
    private Integer discount;
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
    @Enumerated(EnumType.STRING)
    private ItemGender itemGender;
    private Double buyingPrice;
    private String brand;
    private Double sellingPrice;
    private Double expectedProfit;
    private Double profitMargin;
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;
    private String supplierName;
    private Integer itemSoldCount;
    private Integer getStockTotal;
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    @ManyToMany(mappedBy = "inventories")
    private List<Sale> sales;
}
