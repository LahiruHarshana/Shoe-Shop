package lk.ijse.gdse66.shoeshopbackend.repo;


import lk.ijse.gdse66.shoeshopbackend.entity.Inventory;
import lk.ijse.gdse66.shoeshopbackend.entity.Sale;
import lk.ijse.gdse66.shoeshopbackend.entity.SaleInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author : L.H.J
 * @File: SaleInventoryRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Repository
public interface SaleInventoryRepo extends JpaRepository<SaleInventory,Long> {
    SaleInventory findBySaleAndInventory(Sale sale, Inventory inventory);

    @Query(value = "SELECT si.inventory_id, SUM(si.quantity) as max_qty FROM sale s JOIN sale_inventory si on s.sale_id = si.sale_id WHERE DATE(s.purchase_date) = DATE(:selectedDate) GROUP BY si.inventory_id ORDER BY max_qty DESC LIMIT 1", nativeQuery = true)
    String findMaxSaleInventoryByDate(@Param("selectedDate") Date selectedDate);
}
