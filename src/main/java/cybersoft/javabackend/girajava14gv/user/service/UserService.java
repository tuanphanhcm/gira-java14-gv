package cybersoft.javabackend.girajava14gv.user.service;

import javax.validation.Valid;

import cybersoft.javabackend.girajava14gv.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14gv.user.model.User;

public interface UserService {
	User getUserById(long id);

	CreateUserDTO create(CreateUserDTO dto);
}
