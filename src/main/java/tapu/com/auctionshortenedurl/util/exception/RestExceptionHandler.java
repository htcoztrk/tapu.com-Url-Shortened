package tapu.com.auctionshortenedurl.util.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javassist.NotFoundException;


@RestControllerAdvice
public class RestExceptionHandler {

	  //Sistemde bir exception oluşursa bu methodu çağır demek.
	  //Hataları exceptions parametresi olarak verdik
	  //hataları map e ekle ve dondur.
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	 // @ResponseStatus(HttpStatus.BAD_REQUEST)
	  public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exceptions.getMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
	  }
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleExceptions(NotFoundException exception, WebRequest webRequest ){
		ExceptionResponse response=new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity=new ResponseEntity<>(response.getMessage(),HttpStatus.NOT_FOUND);
		return entity;
	}
	
}
