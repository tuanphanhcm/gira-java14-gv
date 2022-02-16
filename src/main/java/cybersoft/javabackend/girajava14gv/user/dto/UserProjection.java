package cybersoft.javabackend.girajava14gv.user.dto;

import java.util.UUID;

public interface UserProjection {
	UUID getId();
	String getUsername();
	String getEmail();
	String getFullname();
}
