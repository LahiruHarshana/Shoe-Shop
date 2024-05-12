package lk.ijse.gdse66.shoeshopbackend.repository;

import lk.ijse.gdse66.shoeshopbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : L.H.J
 * @File: UserRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface UserRepo extends JpaRepository<User, String> {
}
