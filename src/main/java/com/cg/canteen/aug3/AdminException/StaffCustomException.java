package com.cg.canteen.aug3.AdminException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StaffCustomException extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(StaffCustomException.class);

    @ExceptionHandler(StaffNotFoundException.class)
    public ResponseEntity<Object> handleStaffNotFoundException() {
        LOG.error("handleStaffNotFoundException");
        return new ResponseEntity<Object>("Staff Not Found", HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(StaffAlreadyExistsException.class)
    public ResponseEntity<Object> handleStaffAlreadyExistsException() {
        LOG.error("handleStaffAlreadyExistsException");
        return new ResponseEntity<Object>("Staff is Already Exists", HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(PhoneNumberToLongException.class)
    public ResponseEntity<Object> handlePhoneNumberToLongException() {
        LOG.error("handlePhoneNumberToLongException");
        return new ResponseEntity<Object>("Phone Number Should be of 10 digits", HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<Object> handleUsernameAlreadyExistsException() {
        LOG.error("UsernameAlreadyExistsException");
        return new ResponseEntity<Object>("This UserName is already exists Please take another UserName", HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NotEmptyPasswordException.class)
    public ResponseEntity<Object> handleNotEmptyPasswordException() {
        LOG.error("NotEmptyPasswordException");
        return new ResponseEntity<Object>("Password Should No be Empty", HttpStatus.NOT_FOUND);
    }
}
