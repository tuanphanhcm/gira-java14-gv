package cybersoft.javabackend.girajava14gv.role.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14gv.role.model.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "${api.role.name}", description = "${api.role.description}")
public interface RoleController {
	
	
	@Operation(method = "get", description = "get all roles")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get roles successfully"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/roles", produces = "application/json")
	public ResponseEntity<List<RoleDTO>> getRoles();
}
