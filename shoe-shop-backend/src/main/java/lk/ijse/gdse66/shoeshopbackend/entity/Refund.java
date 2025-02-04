package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * @author : L.H.J
 * @File: Refund
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;
    private String saleId;
    private String cashierName;
    @CreationTimestamp
    private Timestamp purchaseDate;
    private double subTotal;
    private String customerName;
    private String itemDescription;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
}
