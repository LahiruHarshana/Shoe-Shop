package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDetailsDTO;
import lk.ijse.gdse66.shoeshopbackend.repository.SaleDetailsRepository;
import lk.ijse.gdse66.shoeshopbackend.service.SaleDetailsService;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : L.H.J
 * @File: SaleDetailsServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Service
public class SaleDetailsServiceImpl implements SaleDetailsService {
    private final SaleDetailsRepository saleDetailsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    SaleDetailsServiceImpl(SaleDetailsRepository saleDetailsRepository, ModelMapper modelMapper){
        this.saleDetailsRepository = saleDetailsRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Integer saveSaleDetails(SaleDetailsDTO saleDetailsDTO) {
        saleDetailsDTO.setActive(true);
        saleDetailsRepository.save(modelMapper.map(saleDetailsDTO, SaleDetails.class));
        return 200;
    }

    @Override
    public Integer disable(String id) {
        SaleDetails saleDetails = saleDetailsRepository.findById(id).orElse(null);
        if (saleDetails != null) {
            saleDetails.setActive(false);
            saleDetailsRepository.save(saleDetails);
            return 200;
        }
        return 500;
    }

    @Override
    public Integer updateSaleDetails(SaleDetailsDTO saleDetailsDTO) {

            SaleDetails entity = modelMapper.map(saleDetailsDTO, SaleDetails.class);
            saleDetailsRepository.save(entity);
            return 200;
    }

    @Override
    public List<SaleDetailsDTO> findAllSaleDetails() {
        return saleDetailsRepository.findAll().stream()
                .map(saleDetails -> modelMapper.map(saleDetails, SaleDetailsDTO.class)).toList();
    }

    @Override
    public Integer enable(String id) {
        SaleDetails saleDetails = saleDetailsRepository.findById(id).orElse(null);
        if (saleDetails != null) {
            saleDetails.setActive(true);
            saleDetailsRepository.save(saleDetails);
            return 200;
        }
        return 500;
    }

    @Override
    public List<SaleDetailsDTO> paginationSaleDetails(PaginationDTO paginationDTO) {
        return saleDetailsRepository
                .findAll(CommonUtils.setPagination(paginationDTO.getOffset(), paginationDTO.getLimit(), paginationDTO.getColumnName()))
                .stream().map(saleDetails -> modelMapper.map(saleDetails, SaleDetailsDTO.class)).toList();

    }
}
