package cybersoft.javabackend.girajava14gv.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
	@NotBlank
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 8)
	private String password;
	
	@NotBlank
	@Size(min = 3)
	private String fullname;

}
