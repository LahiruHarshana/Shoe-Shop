package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SupplierDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import lk.ijse.gdse66.shoeshopbackend.entity.Supplier;
import lk.ijse.gdse66.shoeshopbackend.repository.CustomerRepository;
import lk.ijse.gdse66.shoeshopbackend.repository.SupplierRepository;
import lk.ijse.gdse66.shoeshopbackend.service.SupplierService;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : L.H.J
 * @File: SupplierServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    @Autowired
    SupplierServiceImpl(SupplierRepository supplierRepository , ModelMapper modelMapper){
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Integer saveSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setActive(true);
        supplierRepository.save(modelMapper.map(supplierDTO, Supplier.class));
        return 200;
    }

    @Override
    public Integer disable(String id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setActive(false);
            supplierRepository.save(supplier);
            return 200;
        }
        return 500;
    }

    @Override
    public Integer updateCustomer(SupplierDTO supplierDTO) {
        if (supplierRepository.existsById(supplierDTO.getSupplierCode())) {
            Supplier entity = modelMapper.map(supplierDTO, Supplier.class);
            supplierRepository.save(entity);
            return 200;
        }
        return 500;
    }

    @Override
    public List<SupplierDTO> findAllSupplier() {
        return supplierRepository.findAll().stream()
                .map(supplier -> modelMapper.map(supplier, SupplierDTO.class)).toList();
    }

    @Override
    public Integer enable(String id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setActive(true);
            supplierRepository.save(supplier);
            return 200;
        }
        return 500;
    }

    @Override
    public List<SupplierDTO> paginationCustomers(PaginationDTO paginationDTO) {
        return supplierRepository
                .findAll(CommonUtils.setPagination(paginationDTO.getOffset(), paginationDTO.getLimit(), paginationDTO.getColumnName()))
                .stream().map(supplier -> modelMapper.map(supplier, SupplierDTO.class)).toList();

    }
}
