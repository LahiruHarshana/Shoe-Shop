package lk.ijse.gdse66.shoeshopbackend.projection.impl;

import lk.ijse.gdse66.shoeshopbackend.projection.RefundProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * @author : L.H.J
 * @File: RefundProjectionImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundProjectionImpl implements RefundProjection {
    private String saleId;
    private String cashierName;
    @CreationTimestamp
    private Timestamp purchaseDate;
    private double subTotal;
    private String customerName;
    private String inventoryId;
    private String itemDescription;
    private Integer quantity;
}
