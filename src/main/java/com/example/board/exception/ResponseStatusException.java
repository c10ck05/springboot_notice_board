package com.example.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "데이터를 찾을 수 없습니다.")
public class ResponseStatusException extends RuntimeException{
    public ResponseStatusException(String message) {
        super(message);
    }
}
