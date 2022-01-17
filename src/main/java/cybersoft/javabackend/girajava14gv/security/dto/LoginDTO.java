package cybersoft.javabackend.girajava14gv.security.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	@NotBlank
	@Size(min = 3, max = 36)
	private String username;
	
	@NotBlank
	@Size(min = 8)
	private String password;
}
