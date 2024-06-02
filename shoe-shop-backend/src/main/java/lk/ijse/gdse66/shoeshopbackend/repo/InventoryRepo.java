package lk.ijse.gdse66.shoeshopbackend.repo;

import lk.ijse.gdse66.shoeshopbackend.entity.Inventory;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : L.H.J
 * @File: InventoryRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Repository
public interface InventoryRepo extends JpaRepository<Inventory, String> {
    List<Inventory> findAllByItemStatusNot(ItemStatus itemStatus);

    @Query(value = "SELECT DISTINCT brand FROM inventory" ,nativeQuery = true)
    List<String> getBrands();

    List<Inventory> findAllByBrandAndItemStatusNot(String brand, ItemStatus itemStatus);
}
