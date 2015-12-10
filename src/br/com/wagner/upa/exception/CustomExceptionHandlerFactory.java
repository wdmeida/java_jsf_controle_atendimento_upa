package br.com.wagner.upa.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/*
 * Classe CustomExceptionHandlerFactory responsável por fabricar uma instância da
 * classe CustomExceptionHandler que é responsável por capturar a exceção.
 */
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
	private ExceptionHandlerFactory parent;
	
	public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler handler = new CustomExceptionHandlerFactory(parent).getExceptionHandler();
		return handler;
	}

}
