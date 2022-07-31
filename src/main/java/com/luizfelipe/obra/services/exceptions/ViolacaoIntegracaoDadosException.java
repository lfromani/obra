package com.luizfelipe.obra.services.exceptions;

public class ViolacaoIntegracaoDadosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ViolacaoIntegracaoDadosException(String message, Throwable cause) {
		super(message, cause);
	}

	public ViolacaoIntegracaoDadosException(String message) {
		super(message);
	}

}
