package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: AdminPanel
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-20, Saturday
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "admin_panel")
public class AdminPanel {

    @Id
    private String admin_id;

    @Column(name = "total_sales")
    private Double totalSales;

    @Column(name = "total_profit")
    private Double totalProfit;

    @Column(name = "most_sale_item")
    private String mostSaleItem;

    @Lob
    @Column(name = "most_sale_item_picture")
    private String mostSaleItemPicture;

    @Column(name = "most_sale_item_qty")
    private Integer mostSaleItemQuantity;

}