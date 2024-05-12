package lk.ijse.gdse66.shoeshopbackend.service;

import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDetailsDTO;

import java.util.List;

/**
 * @author : L.H.J
 * @File: SaleDetailsService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public interface SaleDetailsService {
    public Integer saveSaleDetails(SaleDetailsDTO saleDetailsDTO) ;
    public Integer disable(String id);
    public Integer updateSaleDetails(SaleDetailsDTO saleDetailsDTO);
    public List<SaleDetailsDTO> findAllSaleDetails();
    public Integer enable(String id);
    public List<SaleDetailsDTO> paginationSaleDetails(PaginationDTO paginationDTO);
}
