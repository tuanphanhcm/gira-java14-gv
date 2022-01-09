package cybersoft.javabackend.girajava14gv.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14gv.common.ResponseHandler;
import cybersoft.javabackend.girajava14gv.security.jwt.JwtUtils;

@RestController
public class AuthControllerImpl implements AuthController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public ResponseEntity<Object> createTemporaryToken(String username) {
		String token = jwtUtils.generateFakeJwtToken(username);
		return ResponseHandler.getResponse(token, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> verifyFakeToken(String token) {
		boolean isValid = jwtUtils.validateJwtToken(token);
		return ResponseHandler.getResponse(isValid, HttpStatus.OK);
	}

}
