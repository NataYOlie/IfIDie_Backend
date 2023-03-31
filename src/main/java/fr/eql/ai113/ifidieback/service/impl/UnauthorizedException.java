package fr.eql.ai113.ifidieback.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED) //401
public class UnauthorizedException extends Exception {
}

