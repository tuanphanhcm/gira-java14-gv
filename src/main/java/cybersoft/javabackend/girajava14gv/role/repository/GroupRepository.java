package cybersoft.javabackend.girajava14gv.role.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.girajava14gv.role.dto.GroupProjection;
import cybersoft.javabackend.girajava14gv.role.model.GroupRole;

@Repository
public interface GroupRepository extends JpaRepository<GroupRole, UUID> {

	Optional<GroupRole> findByName(String roleName);
	
	@Query("SELECT g.code as code, g.id as id, g.name as name, g.description as description, u.id as userId, u.username as username, u.email as email, u.fullname as fullname FROM GroupRole g LEFT JOIN g.users u")
	Set<GroupProjection> findAllDto();

}
