package trippleM.oceny.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trippleM.oceny.entities.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findAllByEmail (String email);
}
