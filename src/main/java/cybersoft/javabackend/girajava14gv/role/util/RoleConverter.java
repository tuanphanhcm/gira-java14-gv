package cybersoft.javabackend.girajava14gv.role.util;

import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.model.Role;

public class RoleConverter {
	public static RoleDTO toRoleDTO(Role role) {
		return RoleDTO.builder()
			.id(role.getId())
			.name(role.getName())
			.description(role.getDescription())
			.build();
	}
	
	public static List<RoleDTO> toRoleDTOs(List<Role> roles){
		List<RoleDTO> roleDTOs = new ArrayList<>();
		
		for(Role role : roles) {
			roleDTOs.add(RoleConverter.toRoleDTO(role));
		}
		
		return roleDTOs;
	}
}
