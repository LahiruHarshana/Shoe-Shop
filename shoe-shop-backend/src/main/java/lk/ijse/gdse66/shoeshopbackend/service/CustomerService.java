package lk.ijse.gdse66.shoeshopbackend.service;


import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;

import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface CustomerService {
    boolean saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    boolean updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String id);

    String deleteCustomer(String id);

    List<String> getContactList();

    CustomerDTO getCustomerByContact(String id);
}
