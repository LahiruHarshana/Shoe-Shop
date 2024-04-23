package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : L.H.J
 * @File: EmployeeDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeProfilePic;
    private String gender;
    private String status;
    private String designation;
    private String accessRole;
    private Date dob;
    private Date dateOfJoin;
    private String attachedBranch;
    private String addressLine01;
    private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;
    private String contactNo;
    private String email;
    private String emergencyContact;
    private String createBy;
    private String modifyBy;
    private boolean isActive;
}
