package cybersoft.javabackend.girajava14gv.common;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cybersoft.javabackend.girajava14gv.common.utils.ErrorUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object obj, HttpStatus status){
		boolean hasErrors = false;
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (obj instanceof BindingResult) {
			hasErrors = true;
		}
		
		if (hasErrors) {
			map.put("content", "");
			map.put("errors", ErrorUtil.solveError((BindingResult)obj));
		} else {
			map.put("content", obj);
			map.put("errors", "");
		}
		
		// contract with client
		map.put("hasErrors", hasErrors);
		map.put("pageIndex", 1);
		map.put("pageSize", 20);
		map.put("total", 20);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
}
