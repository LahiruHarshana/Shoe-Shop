package lk.ijse.gdse66.shoeshopbackend.repository;

import lk.ijse.gdse66.shoeshopbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author : L.H.J
 * @File: UserRepository
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
