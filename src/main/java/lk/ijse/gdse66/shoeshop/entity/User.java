package lk.ijse.gdse66.shoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: User
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-20, Saturday
 **/


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private String user_id;

    @Column(length = 25)
    private String employeeCode;

    @Column(length = 50)
    private String employeeName;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private UserRole role;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    public enum UserRole {
        ADMIN,
        USER
    }

}
