package cybersoft.javabackend.girajava14gv.role.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.girajava14gv.common.ResponseHandler;

@RestControllerAdvice
public class RoleHandlerException {

	@ExceptionHandler(InvalidRoleException.class)
	public Object handleInvalidRoleException(InvalidRoleException e) {
		
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
