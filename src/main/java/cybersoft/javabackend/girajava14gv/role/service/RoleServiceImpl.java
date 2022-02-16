package cybersoft.javabackend.girajava14gv.role.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.girajava14gv.common.exception.NotFoundException;
import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.dto.UpdateRoleDTO;
import cybersoft.javabackend.girajava14gv.role.exception.InvalidRoleException;
import cybersoft.javabackend.girajava14gv.role.model.Role;
import cybersoft.javabackend.girajava14gv.role.repository.RoleRepository;
import cybersoft.javabackend.girajava14gv.role.util.RoleConverter;

@Service
public class RoleServiceImpl implements RoleService {
	private RoleRepository repository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		repository = roleRepository;
	}

	@Override
	public List<RoleDTO> findAllDTO() {
		List<Role> roles = repository.findAll();
		
		if (roles.isEmpty()) {
			throw new NotFoundException("This is for test only!.");
		}
		
		return RoleConverter.toRoleDTOs(roles);
	}

	public RoleDTO create(RoleDTO dto) {
		Role role = RoleConverter.toRole(dto);
		
		Role createdRole = repository.save(role);
		
		return RoleConverter.toRoleDTO(createdRole);
	}

	@Override
	public Optional<Role> findByName(String roleName) {
		return repository.findByName(roleName);
	}

	@Override
	public RoleDTO updateRole(UUID id, UpdateRoleDTO dto) {
		Optional<Role> roleOpt = repository.findById(id);

		if (!roleOpt.isPresent()) {
			throw new InvalidRoleException("Role id is not valid");
		}
		
		Role role = roleOpt.get();
		
		if (!role.getName().equals(dto.getName())) {
			if (repository.findByName(dto.getName()).isPresent()) {
				throw new InvalidRoleException("Role name has been used.");
			}
			
			role.setName(dto.getName());
		}
		
		if (!role.getCode().equals(dto.getCode())) {
			if (repository.findByCode(dto.getCode()).isPresent()) {
				throw new InvalidRoleException("Role code has been used.");
			}
			
			role.setCode(dto.getCode());
		}
		
		role.setDescription(dto.getDescription());
		
		Role updatedRole = repository.save(role);
		
		return RoleConverter.toRoleDTO(updatedRole);
	}

	@Override
	public void deleteRole(UUID roleId) {
		Optional<Role> roleOpt = repository.findById(roleId);
		
		if (!roleOpt.isPresent())
			throw new InvalidRoleException("Role ID is not existed.");
		
		repository.delete(roleOpt.get());
	}
	
}
