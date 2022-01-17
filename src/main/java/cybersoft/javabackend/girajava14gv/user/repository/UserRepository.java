package cybersoft.javabackend.girajava14gv.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.girajava14gv.security.dto.LoginDTO;
import cybersoft.javabackend.girajava14gv.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.groups WHERE username = ?1")
	Optional<User> findByUsername(String username);

	Optional<LoginDTO> findByUsernameAndPassword(String username, String password);

}
