package cybersoft.javabackend.girajava14gv.role.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.girajava14gv.role.dto.GroupDTO;
import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.model.GroupRole;

public interface GroupRoleService {
	List<GroupDTO> findAll();

	GroupDTO create(GroupDTO dto);

	Optional<GroupRole> findByName(String roleName);

	void deleteRole(long id);
	
	void addUser(long groupId, long userId);
	
	void removeUser(long groupId, long userId);
}
