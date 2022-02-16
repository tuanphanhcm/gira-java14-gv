package cybersoft.javabackend.girajava14gv.role.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
	
	@Query("SELECT r.id as id, r.name as name, r.description as descripton FROM Role r")
	List<RoleDTO> findAllDTO();

	Optional<Role> findByName(String roleName);

	Optional<Role> findByCode(String code);
}
