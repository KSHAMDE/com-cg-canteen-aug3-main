package com.cg.canteen.aug3.AdminException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 

@ControllerAdvice
public class AdminCustomException extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(AdminCustomException.class);

    @ExceptionHandler(SnacksNotFoundException.class)
    public ResponseEntity<Object> handleSnacksNotFoundException() {
        LOG.error("handleSnacksNotFoundException");
        return new ResponseEntity<Object>("Snacks Not Found", HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(BeveragesNotFoundException.class)
    public ResponseEntity<Object> handleBeveragesNotFoundException(){
    	LOG.error("handleBeveragesNotFoundException");
    	return new ResponseEntity<Object>("Beverages Not Found", HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<Object> handleAdminNotFoundException() {
        LOG.error("handleAdminNotFoundException");
        return new ResponseEntity<Object>("Admin Not Found", HttpStatus.NOT_FOUND);
    }
}
