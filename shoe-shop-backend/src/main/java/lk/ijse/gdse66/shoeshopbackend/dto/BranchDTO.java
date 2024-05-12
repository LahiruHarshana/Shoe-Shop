package lk.ijse.gdse66.shoeshopbackend.dto;

import lk.ijse.gdse66.shoeshopbackend.embedded.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author : L.H.J
 * @File: BranchDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {
    private String branchId;
    private String branchName;
    private String branchContact;
    private Address address;
    private Integer noOfEmployees;
    private String branchManager;
    private Timestamp createdDate;
}
