package lk.ijse.gdse66.shoeshopbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.gdse66.shoeshopbackend.embedded.Address;
import lk.ijse.gdse66.shoeshopbackend.enums.Gender;
import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

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
    private String empId;
    private String empName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Gender gender;
    private String emergencyContact;
    private String EmergencyInfo;
    private String status;
    private String email;
    private String contact;
    private String designation;
    private Date dob;
    private Address address;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Role role;
    private String profilePic;
    private Boolean isActive;
    private String branchId;
    private String branchName;
}
