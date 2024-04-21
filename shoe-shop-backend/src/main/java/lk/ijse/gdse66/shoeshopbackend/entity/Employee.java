package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : L.H.J
 * @File: Employee
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-20, Saturday
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(length = 20)
    private String employee_id;

    @Column(length = 25)
    private String employeeCode;

    @Column(length = 50)
    private String employeeName;

    @Lob
    private String employeeProfilePic;

    @Column(length = 10)
    private String gender;

    @Column(length = 20)
    private String status;

    @Column(length = 50)
    private String designation;

    @Column(length = 10)
    private String accessRole; // ENUM: ADMIN, USER

    private Date dob;

    private Date dateOfJoin;

    @Column(length = 50)
    private String attachedBranch;

    @Column(length = 50)
    private String addressLine01; // Preferred building number or name

    @Column(length = 50)
    private String addressLine02; // Preferred lane

    @Column(length = 50)
    private String addressLine03; // Main city

    @Column(length = 50)
    private String addressLine04; // Main state

    @Column(length = 15)
    private String addressLine05; // Postal code

    @Column(length = 15)
    private String contactNo; // Mobile number

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String emergencyContact; // Name of guardian or nominated person for emergency contact

}
