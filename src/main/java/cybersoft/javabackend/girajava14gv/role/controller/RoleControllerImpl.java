package cybersoft.javabackend.girajava14gv.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14gv.role.model.Role;

@RestController
public class RoleControllerImpl implements RoleController {
	
	@Value("${api.role.name}")
	private String name;

	@Override
	public ResponseEntity<List<Role>> getRoles() {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
