package lk.ijse.gdse66.shoeshopbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.gdse66.shoeshopbackend.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private String saleId;
    private Double subTotal;
    private String customerContact;
    private String customerName;
    private Integer addedPoints;
    private String cashierName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private PaymentMethod paymentMethod;
    private Boolean isDemo;
    private List<InventoryDTO> inventories;
    private Integer getqty;
}
