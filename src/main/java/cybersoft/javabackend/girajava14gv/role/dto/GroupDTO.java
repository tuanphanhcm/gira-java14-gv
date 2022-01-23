package cybersoft.javabackend.girajava14gv.role.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.girajava14gv.role.validation.annotation.UniqueRoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDTO {
	
	@NotBlank(message = "{role.name.not-blank}")
	@UniqueRoleName(message = "This group role name can not be used. Please choose another one.")
	private String name;
	
	@NotBlank(message = "{role.code.not-blank}")
	//@UniqueRoleCode
	private String code;
	
	@NotBlank(message = "{role.description.not-blank}")
	private String description;
}
