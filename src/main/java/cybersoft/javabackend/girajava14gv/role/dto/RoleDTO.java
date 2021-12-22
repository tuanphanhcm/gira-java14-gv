package cybersoft.javabackend.girajava14gv.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class RoleDTO {
	private long id; 
	@NotBlank(message = "Role name can not be blank.")
	private String name;
	@NotBlank(message = "Role code can not be blank.")
	private String code;
	@NotBlank(message = "Role descriptioin can not be blank.")
	private String description;
}
