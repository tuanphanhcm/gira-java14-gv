package cybersoft.javabackend.girajava14gv.role.controller;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
	public ResponseEntity<Object> getRoles();
	
	
	@Operation(method = "post", description = "create new role")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "invalid role"),
		@ApiResponse(responseCode = "200", description = "created role successfully")
	})
	@PostMapping(value = "/role")
	public ResponseEntity<Object> createRole(
			@Parameter(description = "role dto") @Valid @RequestBody RoleDTO dto,
				BindingResult bindingResult
			);
}
