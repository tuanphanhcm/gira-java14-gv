package cybersoft.javabackend.girajava14gv.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14gv.common.ResponseHandler;
import cybersoft.javabackend.girajava14gv.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14gv.user.service.UserService;

@RestController
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserService service;

	@Override
	public ResponseEntity<Object> getUsers() {
		return null;
	}

	@Override
	public ResponseEntity<Object> createRole(@Valid CreateUserDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		CreateUserDTO createdUser = service.create(dto);
		
		return ResponseHandler.getResponse(createdUser, HttpStatus.OK);
	}

}
