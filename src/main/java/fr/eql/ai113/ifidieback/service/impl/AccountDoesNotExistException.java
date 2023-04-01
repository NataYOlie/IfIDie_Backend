package fr.eql.ai113.ifidieback.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Aucun compte associé à cet identifiant")
public class AccountDoesNotExistException extends Throwable {
}
