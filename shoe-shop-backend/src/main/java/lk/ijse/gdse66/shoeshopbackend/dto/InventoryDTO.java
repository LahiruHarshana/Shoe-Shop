package lk.ijse.gdse66.shoeshopbackend.dto;

import java.time.LocalDateTime;

/**
 * @author : L.H.J
 * @File: InventoryDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public class InventoryDTO {
    private String itemCode;
    private String itemDesc;
    private String itemPicture;
    private String category;
    private Integer size;
    private String supplierCode;
    private String supplierName;
    private Double unitPriceSale;
    private Double unitPriceBuy;
    private Double expectedProfit;
    private Double profitMargin;
    private String status;
    private String createBy;
    private String modifyBy;
    private boolean isActive;
}
