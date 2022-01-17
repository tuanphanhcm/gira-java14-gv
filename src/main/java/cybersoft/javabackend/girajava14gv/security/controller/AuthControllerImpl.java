package cybersoft.javabackend.girajava14gv.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14gv.common.ResponseHandler;
import cybersoft.javabackend.girajava14gv.security.dto.LoginDTO;
import cybersoft.javabackend.girajava14gv.security.jwt.JwtUtils;
import cybersoft.javabackend.girajava14gv.security.service.AuthService;

@RestController
public class AuthControllerImpl implements AuthController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired 
	private AuthService service;

	@Override
	public ResponseEntity<Object> login(@Valid LoginDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		String token = service.login(dto);
		
		return ResponseHandler.getResponse(token, HttpStatus.OK);
	}

}
