package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.UserDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Employee;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import lk.ijse.gdse66.shoeshopbackend.repository.EmployeeRepo;
import lk.ijse.gdse66.shoeshopbackend.repository.UserRepo;
import lk.ijse.gdse66.shoeshopbackend.service.UserDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author : L.H.J
 * @File: UserDetailServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/

@Service
public class UserDetailServiceImpl implements UserDetailService, UserDetailsService {
    private final UserRepo userRepo;

    private final ModelMapper mapper;

    private final EmployeeRepo employeeRepo;

    public UserDetailServiceImpl(UserRepo userRepo, ModelMapper mapper, EmployeeRepo employeeRepo) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.employeeRepo = employeeRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findById(username).get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public UserDTO loginUser(String userName) {
        User user = userRepo.findById(userName).get();
        if (user.getRole() == Role.SUPER_ADMIN){
            return new UserDTO(user.getUsername(),"1ai2SKEeXSLhr0XQbI1vKyV35gUwfvCvZ",user.getRole());
        }
        Employee employee = employeeRepo.findById(user.getEmployee().getEmpId()).get();
        return new UserDTO(user.getUsername(),employee.getProfilePic(),user.getRole());
    }
}
