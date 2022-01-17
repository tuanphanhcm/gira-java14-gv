package cybersoft.javabackend.girajava14gv.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cybersoft.javabackend.girajava14gv.security.dto.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AuthController {
	@Operation(method = "post", description = "user login to get token")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "login successfully"),
			@ApiResponse(responseCode = "403", description = "incorrect username or password")
	})
	@PostMapping(value = "/api/login", produces = "application/json")
	public ResponseEntity<Object> login(
			@Valid @RequestBody LoginDTO dto, BindingResult bindingResult);
}
