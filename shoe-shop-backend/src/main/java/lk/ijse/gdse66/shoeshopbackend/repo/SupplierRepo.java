package lk.ijse.gdse66.shoeshopbackend.repo;


import lk.ijse.gdse66.shoeshopbackend.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : L.H.J
 * @File: SupplierRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Repository
public interface SupplierRepo extends JpaRepository<Supplier, String> {
    List<Supplier> findAllByIsActive(boolean isActive);
}
