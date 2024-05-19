package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.enums.Level;
import lk.ijse.gdse66.shoeshopbackend.repo.CustomerRepo;
import lk.ijse.gdse66.shoeshopbackend.repo.UserRepo;
import lk.ijse.gdse66.shoeshopbackend.service.CustomerService;
import lk.ijse.gdse66.shoeshopbackend.util.IDGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final ModelMapper mapper;

    private final UserRepo userRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper mapper, UserRepo userRepo) {
        this.customerRepo = customerRepo;
        this.mapper = mapper;
        this.userRepo = userRepo;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        Customer map = mapper.map(customerDTO, Customer.class);
        User user = userRepo.findById(customerDTO.getUserEmail()).get();
        map.setUser(user);
        map.setCustomerId(IDGenerator.generateCustomerId());
        map.setLevel(Level.NEW);
        customerRepo.save(map);
        return true;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll().stream().map(customer -> mapper.map(customer,CustomerDTO.class)).toList();
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepo.findById(customerDTO.getCustomerId()).get();
        mapper.map(customerDTO,customer);
        customerRepo.save(customer);
        return true;
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        return mapper.map(customerRepo.findById(id).get(),CustomerDTO.class);
    }

    @Override
    public String deleteCustomer(String id) {
        customerRepo.deleteById(id);
        return "Customer Deleted !";
    }

    @Override
    public List<String> getContactList() {
        return customerRepo.findAllByContact();
    }

    @Override
    public CustomerDTO getCustomerByContact(String id) {
        return mapper.map(customerRepo.findCustomerByContact(id),CustomerDTO.class);
    }
}
