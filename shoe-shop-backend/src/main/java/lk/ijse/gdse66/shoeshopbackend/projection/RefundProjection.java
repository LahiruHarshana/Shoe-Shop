package lk.ijse.gdse66.shoeshopbackend.projection;

import java.sql.Timestamp;

/**
 * @author : L.H.J
 * @File: RefundProjection
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public interface RefundProjection {
    String getSaleId();

    String getCashierName();

    Timestamp getPurchaseDate();

    double getSubTotal();

    String getCustomerName();

    String getInventoryId();

    String getItemDescription();

    Integer getQuantity();
}
