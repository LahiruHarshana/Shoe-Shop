package lk.ijse.gdse66.shoeshopbackend.repo;


import lk.ijse.gdse66.shoeshopbackend.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : L.H.J
 * @File: BranchRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Repository
public interface BranchRepo extends JpaRepository<Branch, String> {
}
