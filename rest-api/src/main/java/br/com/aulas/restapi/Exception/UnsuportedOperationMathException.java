package br.com.aulas.restapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedOperationMathException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnsuportedOperationMathException(String message){
        super(message);
    }
    
}
