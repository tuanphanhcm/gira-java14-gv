package cybersoft.javabackend.girajava14gv.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.girajava14gv.common.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {NotFoundException.class})
	public Object handleNotFoundException(NotFoundException e) {
		log.debug("ERROR CATCHED : {}", e);
		return ResponseHandler.getErrorResponse(e.getMessage()
				, HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(value = {Exception.class})
//	public Object handleUnexpectedException(Exception e) {
//		
//		return ResponseHandler.getErrorResponse(e.getMessage()
//				, HttpStatus.BAD_REQUEST);
//	}
}
