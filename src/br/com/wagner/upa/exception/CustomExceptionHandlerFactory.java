package br.com.wagner.upa.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/*
 * Classe CustomExceptionHandlerFactory respons�vel por fabricar uma inst�ncia da
 * classe CustomExceptionHandler que � respons�vel por capturar a exce��o.
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
