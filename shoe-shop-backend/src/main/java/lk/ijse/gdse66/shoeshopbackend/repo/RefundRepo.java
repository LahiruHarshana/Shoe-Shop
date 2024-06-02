package lk.ijse.gdse66.shoeshopbackend.repo;

import lk.ijse.gdse66.shoeshopbackend.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : L.H.J
 * @File: RefundRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Repository
public interface RefundRepo extends JpaRepository<Refund,Long> {

    @Query(value = "SELECT SUM(sub_total) as total from refund",nativeQuery = true)
    Double findBySum();
}
