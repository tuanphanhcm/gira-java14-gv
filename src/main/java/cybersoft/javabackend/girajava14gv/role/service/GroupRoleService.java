package cybersoft.javabackend.girajava14gv.role.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import cybersoft.javabackend.girajava14gv.role.dto.GroupDTO;
import cybersoft.javabackend.girajava14gv.role.dto.GroupProjection;
import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.model.GroupRole;

public interface GroupRoleService {
	List<GroupDTO> findAll();

	GroupDTO create(GroupDTO dto);

	Optional<GroupRole> findByName(String roleName);

	void deleteRole(UUID id);
	
	void addUser(UUID groupId, UUID userId);
	
	void removeUser(UUID groupId, UUID userId);

	Set<GroupProjection> findAllDto();
}
