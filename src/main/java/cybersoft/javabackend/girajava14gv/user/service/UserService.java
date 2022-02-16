package cybersoft.javabackend.girajava14gv.user.service;

import java.util.UUID;


import cybersoft.javabackend.girajava14gv.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14gv.user.model.User;

public interface UserService {
	User getUserById(UUID id);

	CreateUserDTO create(CreateUserDTO dto);
}
