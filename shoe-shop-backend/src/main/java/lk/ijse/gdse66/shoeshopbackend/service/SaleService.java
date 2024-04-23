package lk.ijse.gdse66.shoeshopbackend.service;

import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Sale;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : L.H.J
 * @File: SaleService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public interface SaleService{
    public Integer saveSale(SaleDTO saleDTO);

    public Integer disable(String id);

    public Integer updateSale(SaleDTO saleDTO);

    public List<SaleDTO> findAllSale();

    public Integer enable(String id);

    public List<SaleDTO> paginationSale(PaginationDTO paginationDTO);
}
