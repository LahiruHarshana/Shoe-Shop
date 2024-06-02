package lk.ijse.gdse66.shoeshopbackend.repo;


import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query("SELECT c.contact FROM Customer c")
    List<String> findAllByContact();
    Customer findCustomerByContact(String contact);

}
