package lk.ijse.gdse66.shoeshopbackend.service;

import lk.ijse.gdse66.shoeshopbackend.dto.EmployeeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author : L.H.J
 * @File: EmployeeService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface EmployeeService {

    boolean saveEmployee(EmployeeDTO employee, MultipartFile file) throws IOException;
   List<EmployeeDTO> getAllAdmins();
   List<EmployeeDTO> getAllCashiers();
   EmployeeDTO getEmployee(String empId);
   boolean updateEmployee(EmployeeDTO employeeDTO,MultipartFile file) throws IOException;
}
