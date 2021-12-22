package cybersoft.javabackend.girajava14gv.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.model.Role;
import cybersoft.javabackend.girajava14gv.role.service.RoleService;

@RestController
public class RoleControllerImpl implements RoleController {
	private RoleService service;
	
	public RoleControllerImpl(RoleService roleService) {
		service = roleService;
	}

	@Override
	public ResponseEntity<List<RoleDTO>> getRoles() {
		List<RoleDTO> roles = service.findAllDTO();
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createRole(RoleDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		RoleDTO createdRole = service.create(dto);
		
		return new ResponseEntity<>(createdRole, HttpStatus.OK);
	}
	
}
