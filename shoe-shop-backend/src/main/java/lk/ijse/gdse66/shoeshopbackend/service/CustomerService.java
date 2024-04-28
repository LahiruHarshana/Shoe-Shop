package lk.ijse.gdse66.shoeshopbackend.service;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import lk.ijse.gdse66.shoeshopbackend.repository.CustomerRepository;

import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

public interface CustomerService {
    public Integer saveCustomer(CustomerDTO customerDTO);
    public Integer disable(String id);
    public Integer updateCustomer(CustomerDTO customerDTO);
    public List<CustomerDTO> findAllCustomers();
    public Integer enable(String id);
    public List<CustomerDTO> paginationCustomers(PaginationDTO paginationDTO);
    CustomerDTO findCustomerById(String customerId);
}
