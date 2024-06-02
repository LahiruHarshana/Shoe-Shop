package lk.ijse.gdse66.shoeshopbackend.util;

import jakarta.annotation.PostConstruct;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import lk.ijse.gdse66.shoeshopbackend.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : L.H.J
 * @File: Init
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-06-02, Sunday
 **/
@Service
public class Init {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public Init(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
        if (userRepo.count() == 0){
            //userRepo.save(User.builder().username("admin").password(passwordEncoder.encode("admin")).role(Role.ADMIN).build());
        }
    }
}
