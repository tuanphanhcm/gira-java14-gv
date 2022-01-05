package cybersoft.javabackend.girajava14gv.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.girajava14gv.user.model.User;
import cybersoft.javabackend.girajava14gv.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User getUserById(long id) {
		Optional<User> userOpt = repository.findById(id);
		
		if(userOpt.isPresent())
			return userOpt.get();
		
		return null;
	}
}
