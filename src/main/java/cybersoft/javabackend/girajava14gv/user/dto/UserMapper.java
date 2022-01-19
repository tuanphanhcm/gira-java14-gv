package cybersoft.javabackend.girajava14gv.user.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.girajava14gv.user.model.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User createUserDtoToUserEntity(CreateUserDTO dto);
	
	CreateUserDTO userEntityToCreateUserDTO(User entity);
}
