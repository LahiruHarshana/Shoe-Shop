package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: SaleDetailsDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetailsDTO {
    private String saleDetailsId;
    private String orderNo;
    private String itemCode;
    private Integer quantity;
    private Double unitPrice;
    private String createBy;
    private String modifyBy;
    private boolean isActive;
}
