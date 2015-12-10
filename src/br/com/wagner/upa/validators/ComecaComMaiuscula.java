package br.com.wagner.upa.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("comecaComMaiuscula")
public class ComecaComMaiuscula implements Validator{

	@Override
	public void validate(FacesContext fc, UIComponent component, Object obj)
			throws ValidatorException {
		
		String valor = obj.toString();
		if(!valor.matches("[A-Z].*")) throw new ValidatorException(new FacesMessage("Deve iniciar com letra maiúscula."));
	}
	
}
