package com.MovieApplication.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Movie not found, exception handled by Custom exception")
public class MovieNotFoundException extends Exception {

}
