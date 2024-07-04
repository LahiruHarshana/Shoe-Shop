package lk.ijse.gdse66.shoeshopbackend.api;

import lk.ijse.gdse66.shoeshopbackend.dto.RefundRequestDTO;
import lk.ijse.gdse66.shoeshopbackend.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * @author : L.H.J
 * @File: RefundController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/refund")
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @PostMapping
    public ResponseEntity<?> addRefund(@RequestBody RefundRequestDTO refundDTO){
        try{
            boolean isSave = refundService.addRefund(refundDTO);
            logger.info("Refund Saved !");
            return isSave ? ResponseEntity.ok("Refund Saved !") : ResponseEntity.badRequest().body("Failed to save the refund");
        }catch (Exception e) {
            logger.severe(e.getMessage());
            return ResponseEntity.badRequest().body("Failed to save the refund");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllRefunds(){
        try{
            logger.info("All Refunds Fetched !");
            return ResponseEntity.ok(refundService.getAllRefunds());
        }catch (Exception e){
            logger.severe(e.getMessage());
            return ResponseEntity.badRequest().body("Failed to get the refunds");
        }
    }

    @GetMapping("/get-total")
    public ResponseEntity<?> getRefundTotal(){
        try{
            logger.info("Refund Total Fetched !");
            return ResponseEntity.ok(refundService.getTotal());
        }catch (Exception e){
            logger.severe(e.getMessage());
            return ResponseEntity.badRequest().body("Failed to get the refund total");
        }
    }
}
