package ru.myaccounting.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransferNotFoundException extends RuntimeException{
    public TransferNotFoundException(String msg) {
        super(msg);
    }
}
