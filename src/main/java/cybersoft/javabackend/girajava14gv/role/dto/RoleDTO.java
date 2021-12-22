package cybersoft.javabackend.girajava14gv.role.dto;

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
	private String name;
	private String description;
}
