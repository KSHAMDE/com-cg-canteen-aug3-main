package com.cg.canteen.aug3.AdminException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StaffAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
    
    public StaffAlreadyExistsException() {
        super();
    }

}
