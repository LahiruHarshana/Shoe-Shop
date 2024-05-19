package lk.ijse.gdse66.shoeshopbackend.service;


import lk.ijse.gdse66.shoeshopbackend.dto.SupplierDTO;

import java.util.List;

/**
 * @author : L.H.J
 * @File: SupplierService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface SupplierService {
    boolean saveSupplier(SupplierDTO supplierDTO);

    List<SupplierDTO> getAllSuppliers();

    SupplierDTO getSupplier(String id);

    boolean updateSupplier(SupplierDTO supplierDTO);

    boolean deleteSupplier(String id);

    List<String> getSupplierId();
}
