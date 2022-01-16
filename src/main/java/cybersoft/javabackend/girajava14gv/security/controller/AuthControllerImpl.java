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

@RestController
public class AuthControllerImpl implements AuthController {
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public ResponseEntity<Object> login(@Valid LoginDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		return null;
	}

}
