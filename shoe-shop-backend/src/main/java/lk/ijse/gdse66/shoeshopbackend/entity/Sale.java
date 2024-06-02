package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeshopbackend.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author : L.H.J
 * @File: Sale
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    private String saleId;
//    private String itemDescription;
    private Integer getqty;
//    private Integer size;
//    private Double unitPrice;
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

    @OneToMany(mappedBy = "sale")
    private List<SaleInventory> saleInventories;
}
