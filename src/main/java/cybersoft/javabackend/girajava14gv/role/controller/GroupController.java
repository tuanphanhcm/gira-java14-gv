package cybersoft.javabackend.girajava14gv.role.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cybersoft.javabackend.girajava14gv.role.dto.GroupDTO;

@RequestMapping("/api/groups")
public interface GroupController {
	
	@GetMapping
	public ResponseEntity<Object> findGroups();
	
	@GetMapping("/dto")
	public ResponseEntity<Object> findAllDto();
	
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody GroupDTO dto, BindingResult result);
	
	@PostMapping("/{group-id}/add-user")
	public ResponseEntity<Object> addUser(
			@PathVariable("group-id")
			UUID groupId, 
			@RequestParam("user-id") UUID userId);
	
	@PostMapping("/{group-id}/remove-user")
	public ResponseEntity<Object> removeUser(
			@PathVariable("group-id")
			UUID groupId, 
			@RequestParam("user-id") UUID userId);
}
