package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import lk.ijse.gdse66.shoeshopbackend.repository.CustomerRepository;
import lk.ijse.gdse66.shoeshopbackend.service.CustomerService;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper){
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Integer saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setActive(true);
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
        return 200;
    }

    @Override
    public Integer disable(String id) {
        Customer userEntity = customerRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userEntity.setActive(false);
            customerRepository.save(userEntity);
            return 200;
        }
        return 500;
    }

    @Override
    public Integer updateCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsById(customerDTO.getCustomerCode())) {
            Customer entity = modelMapper.map(customerDTO, Customer.class);
            customerRepository.save(entity);
            return 200;
        }
        return 500;
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(userEntity -> modelMapper.map(userEntity, CustomerDTO.class)).toList();
    }

    @Override
    public Integer enable(String id) {
        Customer userEntity = customerRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userEntity.setActive(true);
            customerRepository.save(userEntity);
            return 200;
        }
        return 500;
    }

    @Override
    public List<CustomerDTO> paginationCustomers(PaginationDTO paginationDTO) {
        return customerRepository
                .findAll(CommonUtils.setPagination(paginationDTO.getOffset(), paginationDTO.getLimit(), paginationDTO.getColumnName()))
                .stream().map(userEntity -> modelMapper.map(userEntity, CustomerDTO.class)).toList();

    }
}
