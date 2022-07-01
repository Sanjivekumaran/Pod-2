package com.cts.consumermodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ConsumerBusiness Not Found")
public class ConsumerBusinessNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
}


