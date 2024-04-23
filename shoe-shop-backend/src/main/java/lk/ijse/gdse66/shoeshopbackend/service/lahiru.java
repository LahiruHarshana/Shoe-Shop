package lk.ijse.gdse66.shoeshopbackend.service;

import jakarta.annotation.PostConstruct;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : L.H.J
 * @File: lahiru
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Service
public class lahiru {
    @Autowired
    UserRepository userRepository;


    @PostConstruct
    void add(){
        if (userRepository.count()==0){
            userRepository.save(User.builder().isActive(true).email("lahrshana2002@gmail.com").password("$2a$12$nDtDXrQc1bXHAiDRE7i1i.OayPoHReeNkp1hAEXWTa5YP6tDpyw0u").role(User.UserRole.ADMIN).username("lahiru").userId("1").modifyBy("lahiru").createBy("lahiru").build());
        }else {
            System.out.println("not exist");
        }
        System.out.println("add");
    }
}
