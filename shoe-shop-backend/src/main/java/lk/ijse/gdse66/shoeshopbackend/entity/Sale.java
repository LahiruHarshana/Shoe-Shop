package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDetailsDTO;
import lk.ijse.gdse66.shoeshopbackend.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : L.H.J
 * @File: Sale
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    private String saleId;
    private Integer getqty;
    private Double subTotal;
    private String customerName;
    private String cashierName;
    private Integer addedPoints;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @CreationTimestamp
    private Timestamp purchaseDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "sale_inventory",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id")
    )
    private List<Inventory> inventories;
}
