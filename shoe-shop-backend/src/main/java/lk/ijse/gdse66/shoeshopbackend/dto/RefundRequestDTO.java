package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: RefundRequestDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundRequestDTO {
    private String saleId;
    private String inventoryId;
    private Integer quantity;
}
