package hu.unideb.inf.dandy.szd.web.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class UserDoesntExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}