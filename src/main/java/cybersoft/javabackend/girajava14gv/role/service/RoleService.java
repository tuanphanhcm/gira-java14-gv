package cybersoft.javabackend.girajava14gv.role.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.dto.UpdateRoleDTO;
import cybersoft.javabackend.girajava14gv.role.model.Role;

public interface RoleService {

	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

	Optional<Role> findByName(String roleName);

	RoleDTO updateRole(UUID id, UpdateRoleDTO dto);

	void deleteRole(UUID id);

}
