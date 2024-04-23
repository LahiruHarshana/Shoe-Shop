package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Inventory;
import lk.ijse.gdse66.shoeshopbackend.entity.Sale;
import lk.ijse.gdse66.shoeshopbackend.repository.InventoryRepository;
import lk.ijse.gdse66.shoeshopbackend.repository.SaleRepository;
import lk.ijse.gdse66.shoeshopbackend.service.SaleService;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : L.H.J
 * @File: SaleServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper){
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Integer saveSale(SaleDTO saleDTO) {
        saleDTO.setActive(true);
        saleRepository.save(modelMapper.map(saleDTO, Sale.class));
        return 200;
    }

    @Override
    public Integer disable(String id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if (sale != null) {
            sale.setActive(false);
            saleRepository.save(sale);
            return 200;
        }
        return 500;
    }

    @Override
    public Integer updateSale(SaleDTO saleDTO) {
        if (saleRepository.existsById(saleDTO.getOrderNo())) {
            Sale entity = modelMapper.map(saleDTO, Sale.class);
            saleRepository.save(entity);
            return 200;
        }
        return 500;
    }

    @Override
    public List<SaleDTO> findAllSale() {
        return saleRepository.findAll().stream()
                .map(sale -> modelMapper.map(sale, SaleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Integer enable(String id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if (sale != null) {
            sale.setActive(true);
            saleRepository.save(sale);
            return 200;
        }
        return 500;
    }

    @Override
    public List<SaleDTO> paginationSale(PaginationDTO paginationDTO) {
        return saleRepository.findAll(CommonUtils.setPagination(paginationDTO.getOffset(), paginationDTO.getLimit(), paginationDTO.getColumnName()))
                .stream()
                .map(sale -> modelMapper.map(sale, SaleDTO.class))
                .collect(Collectors.toList());

    }
}
