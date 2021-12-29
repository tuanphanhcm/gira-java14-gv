package cybersoft.javabackend.girajava14gv.common.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorUtil {

	public static Object solveError(BindingResult bindingResult) {
		List<String> errorMessages = new LinkedList<>();
		List<ObjectError> errors = bindingResult.getAllErrors();
		
		for (ObjectError error : errors) {
			errorMessages.add(error.getDefaultMessage());
		}
		
		return errorMessages;
	}

}
