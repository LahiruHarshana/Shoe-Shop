package lk.ijse.gdse66.shoeshopbackend.service;


import lk.ijse.gdse66.shoeshopbackend.dto.RefundDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.RefundRequestDTO;

import java.util.List;

/**
 * @author : L.H.J
 * @File: RefundService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public interface RefundService {
    boolean addRefund(RefundRequestDTO refundDTO);

    List<RefundDTO> getAllRefunds();

    Double getTotal();
}
