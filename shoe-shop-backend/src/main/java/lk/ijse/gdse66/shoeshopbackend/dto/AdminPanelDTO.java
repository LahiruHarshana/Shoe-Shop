package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: AdminPanelDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminPanelDTO {
    private String adminId;
    private Double totalSales;
    private Double totalProfit;
    private String mostSaleItem;
    private String mostSaleItemPicture;
    private Integer mostSaleItemQuantity;
}
