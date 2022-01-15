package cybersoft.javabackend.girajava14gv.role.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.girajava14gv.role.dto.RoleDTO;
import lombok.extern.slf4j.Slf4j;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@Transactional
@Slf4j
public class RoleServiceTest {
	
	@Autowired
	private RoleService service;
	
	private RoleDTO dto;
	
	@BeforeAll
	public void setupTest() {
		log.debug("Post Construct has been called.");
		dto = RoleDTO.builder()
				.code("TST")
				.name("TESTROLE")
				.description("TEST DESCRIPTION")
				.build();
	}
	
	@Test
	public void shouldLoadRoleServiceNormally() {
		assertNotEquals(service, null);
	}
	
	@Test
	public void shouldFoundDtos() {
		RoleDTO result  = service.create(dto);
		assertNotEquals(result, null);
		List<RoleDTO> dtos = service.findAllDTO();
		
		assertNotEquals(dtos.size(), 0);
	}
}
