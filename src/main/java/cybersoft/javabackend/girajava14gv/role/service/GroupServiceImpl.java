package cybersoft.javabackend.girajava14gv.role.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.girajava14gv.common.exception.GiraEntityNotFoundException;
import cybersoft.javabackend.girajava14gv.role.dto.GroupDTO;
import cybersoft.javabackend.girajava14gv.role.dto.GroupMapper;
import cybersoft.javabackend.girajava14gv.role.model.GroupRole;
import cybersoft.javabackend.girajava14gv.role.repository.GroupRepository;
import cybersoft.javabackend.girajava14gv.user.model.User;
import cybersoft.javabackend.girajava14gv.user.repository.UserRepository;

@Service
public class GroupServiceImpl implements GroupRoleService {
	@Autowired
	private GroupRepository repository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<GroupDTO> findAll() {
		List<GroupRole> groups = repository.findAll();
		return groups.stream()
				.map(r -> GroupMapper.INSTANCE.fromEntityToGroupDTO(r))
				.collect(Collectors.toList());
	}

	@Override
	public GroupDTO create(GroupDTO dto) {
		GroupRole group = GroupRole.builder()
							.code(dto.getCode())
							.name(dto.getName())
							.description(dto.getDescription())
							.build();
		
		group = repository.save(group);
		return GroupMapper.INSTANCE.fromEntityToGroupDTO(group);
	}

	@Override
	public Optional<GroupRole> findByName(String roleName) {
		return repository.findByName(roleName);
	}

	@Override
	public void deleteRole(long id) {
		repository.deleteById(id);
	}

	@Override
	public void addUser(long groupId, long userId) {
		GroupRole group = null;
		try {
			group = repository.getById(groupId);
		} catch (EntityNotFoundException e) {
			throw new GiraEntityNotFoundException("Group Role is not existed.");
		}
		
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new GiraEntityNotFoundException("User is not existed"));
		
		group.addUser(user);
		repository.flush();
		// repository.save(group);
	}

	@Override
	public void removeUser(long groupId, long userId) {
		GroupRole group = repository.findById(groupId)
			.orElseThrow(
					() -> new GiraEntityNotFoundException("Group is not existed."));
		
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new GiraEntityNotFoundException("User is not existed"));
		
		group.removeUser(user);
		repository.save(group);
		
		// SIDE EFFECTS
	}



}
