package lk.ijse.gdse66.shoeshopbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeshopbackend.embedded.Address;
import lk.ijse.gdse66.shoeshopbackend.enums.Gender;
import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    private String empId;
    private String empName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String emergencyContact;
    private String EmergencyInfo;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String profilePic;
    private String status;
    @Column(unique = true)
    private String email;
    private String contact;
    private Boolean isActive;
    private String designation;
    private Date dob;
    private Address address;
    @CreationTimestamp
    private Timestamp regDate;
    @ManyToOne
    @JoinColumn(name = "branch_Id", referencedColumnName = "branchId")
    private Branch branch;
}
