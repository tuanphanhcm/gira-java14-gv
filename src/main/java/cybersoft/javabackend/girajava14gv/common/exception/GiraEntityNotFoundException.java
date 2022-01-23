package cybersoft.javabackend.girajava14gv.common.exception;

import javax.persistence.EntityNotFoundException;

public class GiraEntityNotFoundException extends EntityNotFoundException {
	public GiraEntityNotFoundException(String msg) {
		super(msg);
	}
}
