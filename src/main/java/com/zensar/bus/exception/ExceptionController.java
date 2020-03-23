package com.zensar.bus.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;



@ControllerAdvice
public class ExceptionController {
	 @ExceptionHandler(value =UserNotfoundException.class)
	   public ResponseEntity<Object> exception(UserNotfoundException exception) {
	      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	 }
	 @ExceptionHandler(value =RouteNotfoundException.class)
	   public ResponseEntity<Object> exception(RouteNotfoundException exception) {
	      return new ResponseEntity<>("route unavailable", HttpStatus.NOT_FOUND);
	 }
	 @ExceptionHandler(value =PickupPointNotfoundException.class)
	   public ResponseEntity<Object> exception(PickupPointNotfoundException exception) {
	      return new ResponseEntity<>("pickup point not available", HttpStatus.NOT_FOUND);
	 }
	 @ExceptionHandler(value =SeatUnavailableException.class)
	   public ResponseEntity<Object> exception(SeatUnavailableException exception) {
	      return new ResponseEntity<>("Seats are not available", HttpStatus.NOT_FOUND);
	 }
	 @ExceptionHandler(value =NotNullException.class)
	   public ResponseEntity<Object> exception(NotNullException exception) {
	      return new ResponseEntity<>("All fields are mandatory and can not be null", HttpStatus.BAD_REQUEST);
	 }
	 @ResponseStatus(HttpStatus.BAD_REQUEST )
	    @ResponseBody
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
	        return processFieldErrors(fieldErrors);
	    }

	    private Error processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
	        Error error = new Error(HttpStatus.BAD_REQUEST .value(), "validation error");
	        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
	            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
	        }
	        return error;
	    }

	    static class Error {
	        private final int status;
	        private final String message;
	        private List<FieldError> fieldErrors = new ArrayList<>();

	        Error(int status, String message) {
	            this.status = status;
	            this.message = message;
	        }

	        public int getStatus() {
	            return status;
	        }

	        public String getMessage() {
	            return message;
	        }

	        public void addFieldError(String field, String message) {
	            FieldError error = new FieldError("encrypted token", field, message);	            
	            fieldErrors.add(error);
	        }

	        public List<FieldError> getFieldErrors() {
	            return fieldErrors;
	        }
	    }
}

