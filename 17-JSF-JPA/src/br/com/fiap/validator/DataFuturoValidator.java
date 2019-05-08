package br.com.fiap.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dataFuturo")
public class DataFuturoValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		//Pegar o valor para validar 
		Date data = (Date) arg2; 
		
		//Validar data no futuro
		if (data.after(new Date())) {
			throw new ValidatorException(new FacesMessage("Data no futuro"));
		}
	}

}