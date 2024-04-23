package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : L.H.J
 * @File: SaleDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {
    private String orderNo;
    private String itemCode;
    private String customerName;
    private String itemDesc;
    private Integer size;
    private Double unitPrice;
    private Integer itemQty;
    private Double totalPrice;
    private Date purchaseDate;
    private String paymentMethod;
    private Double addedPoints;
    private String userId;
    private String customerId;
    private String cashierName;
    private String createBy;
    private String modifyBy;
    private boolean isActive;
}
