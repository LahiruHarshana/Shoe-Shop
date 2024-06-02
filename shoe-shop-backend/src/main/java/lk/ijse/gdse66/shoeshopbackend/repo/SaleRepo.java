package lk.ijse.gdse66.shoeshopbackend.repo;

import lk.ijse.gdse66.shoeshopbackend.entity.Sale;
import lk.ijse.gdse66.shoeshopbackend.projection.RefundProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author : L.H.J
 * @File: SaleRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Repository
public interface SaleRepo extends JpaRepository<Sale,String> {
    @Query(value = "SELECT s.sale_id as saleId,s.cashier_name as cashierName,s.purchase_date as purchaseDate,sub_total as subTotal, sd.quantity as quantity,s.customer_name as customerName,sd.inventory_id as inventoryId,i.item_description as itemDescription from sale s JOIN sale_inventory sd ON s.sale_id = sd.sale_id Join inventory i on sd.inventory_id = i.item_code WHERE s.purchase_date >= DATE_SUB(CURDATE(), INTERVAL 3 DAY) order by s.purchase_date desc",nativeQuery = true)
    List<RefundProjection> getCanRefundItems();

    @Query(value = "SELECT SUM(sub_total) from sale",nativeQuery = true)
    Double findSumOfTotal();

    @Query(value ="SELECT SUM(sub_total) from sale WHERE DATE(purchase_date) = DATE(:selectedDate)",nativeQuery = true)
    Double findSumOfTotalByDate(@Param("selectedDate") Date date);
}
