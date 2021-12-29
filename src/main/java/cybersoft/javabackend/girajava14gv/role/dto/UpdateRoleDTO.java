package cybersoft.javabackend.girajava14gv.role.dto;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateRoleDTO {
	@NotBlank(message = "{role.name.not-blank}")
	private String name;
	
	@NotBlank(message = "{role.code.not-blank}")
	private String code;
	
	@NotBlank(message = "{role.description.not-blank}")
	private String description;
}
