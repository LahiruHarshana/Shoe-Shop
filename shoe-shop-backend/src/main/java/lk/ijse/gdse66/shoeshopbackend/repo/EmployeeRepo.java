package lk.ijse.gdse66.shoeshopbackend.repo;

import lk.ijse.gdse66.shoeshopbackend.entity.Employee;
import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : L.H.J
 * @File: EmployeeRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
    List<Employee> findAllByRole(Role role);
}
