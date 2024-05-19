package lk.ijse.gdse66.shoeshopbackend.api;


import lk.ijse.gdse66.shoeshopbackend.dto.SaleDTO;
import lk.ijse.gdse66.shoeshopbackend.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : L.H.J
 * @File: SaleController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<?> saveSale(@RequestBody SaleDTO saleDTO){
        boolean isPlaced = saleService.saveSale(saleDTO);
        return isPlaced ? ResponseEntity.ok("Sale Placed") : ResponseEntity.badRequest().body("Sale Not Placed");
    }
}
