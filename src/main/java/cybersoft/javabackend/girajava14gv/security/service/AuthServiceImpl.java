package cybersoft.javabackend.girajava14gv.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.girajava14gv.common.exception.IncorrectLoginException;
import cybersoft.javabackend.girajava14gv.security.dto.LoginDTO;
import cybersoft.javabackend.girajava14gv.security.jwt.JwtUtils;
import cybersoft.javabackend.girajava14gv.user.model.User;
import cybersoft.javabackend.girajava14gv.user.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public String login(LoginDTO dto) {
		// 1. search user by username and password
		Optional<User> userOpt = 
				userRepository.findByUsername(
						dto.getUsername());
		
		// 2. if user is null return IncorrectLoginException
		if (!userOpt.isPresent()) {
			throw new IncorrectLoginException("Incorrect username or password.");
		}
		
		String encodedPassword = userOpt.get().getPassword();
		
		if (!encoder.matches(dto.getPassword(), encodedPassword)) {
			throw new IncorrectLoginException("Incorrect username or password.");
		}
		
		// 3. create authentication and set into SecurityContext
		UserDetails user = userDetailsService.loadUserByUsername(dto.getUsername());
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		// 4. generate jwt token
		return jwtUtils.generateJwtToken(auth);
	}
	
}
