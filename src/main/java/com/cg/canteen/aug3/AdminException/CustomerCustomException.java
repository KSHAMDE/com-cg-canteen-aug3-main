package com.cg.canteen.aug3.AdminException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerCustomException extends ResponseEntityExceptionHandler {
	
	    private static final Logger LOG = LoggerFactory.getLogger(CustomerCustomException.class);

	    @ExceptionHandler(CustomerNotFoundException.class)
	    public ResponseEntity<Object> handleCustomerNotFoundException() {
	        LOG.error("handleCustomerNotFoundException");
	        return new ResponseEntity<Object>("Customer Not Found", HttpStatus.NOT_FOUND);
	    }
	    
	}

