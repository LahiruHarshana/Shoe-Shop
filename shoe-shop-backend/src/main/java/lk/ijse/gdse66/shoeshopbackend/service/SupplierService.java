package lk.ijse.gdse66.shoeshopbackend.service;

import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SupplierDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Supplier;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;

import java.util.List;

/**
 * @author : L.H.J
 * @File: SupplierService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public interface SupplierService {
    public Integer saveSupplier(SupplierDTO supplierDTO);
    public Integer disable(String id);
    public Integer updateCustomer(SupplierDTO supplierDTO) ;
    public List<SupplierDTO> findAllSupplier() ;
    public Integer enable(String id);
    public List<SupplierDTO> paginationSupplier(PaginationDTO paginationDTO);
}
