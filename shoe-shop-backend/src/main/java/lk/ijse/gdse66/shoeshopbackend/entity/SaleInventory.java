package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * @author : L.H.J
 * @File: SaleInventory
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Getter
@Setter
@Entity
@Table(name = "sale_inventory")
public class SaleInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Column(nullable = false)
    private int quantity;
}
