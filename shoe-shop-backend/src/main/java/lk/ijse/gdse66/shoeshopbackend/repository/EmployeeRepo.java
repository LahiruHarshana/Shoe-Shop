package lk.ijse.gdse66.shoeshopbackend.repository;

import lk.ijse.gdse66.shoeshopbackend.entity.Employee;
import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : L.H.J
 * @File: EmployeeRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface EmployeeRepo extends JpaRepository<Employee, String> {
    List<Employee> findAllByRole(Role role);

}
