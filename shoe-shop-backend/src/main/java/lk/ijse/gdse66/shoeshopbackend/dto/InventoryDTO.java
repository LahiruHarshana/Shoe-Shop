package lk.ijse.gdse66.shoeshopbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemGender;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemStatus;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : L.H.J
 * @File: InventoryDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
    private String itemCode;
    private String supplierId;
    private String itemDescription;
    private String itemPicture;
    private Integer qtyOnHand;
    private Integer size;
    private Double buyingPrice;
    private Integer getqty;
    private String brand;
    private Double sellingPrice;
    private Double expectedProfit;
    private Integer itemSoldCount;
    private Integer getStockTotal;
    private Double profitMargin;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ItemStatus itemStatus;
    private Integer discount;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ItemType itemType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ItemGender itemGender;
    private SupplierDTO supplier;
}
