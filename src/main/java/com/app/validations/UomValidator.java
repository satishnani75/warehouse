package com.app.validations;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

@Component
public class UomValidator implements Validator {

	@Autowired
	private IUomService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return new Uom().equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		
		                     Uom uom =(Uom) target;
		                     
		// uom model code validatioan
		                     
		  if(Pattern.matches("[A-z]  {4,6}  ", uom.getUomModel()))   {
			  
			  errors.rejectValue("uomModel", null, "enter valid uom  ");
			  
			  
		  }else if (service.isUomModelExist(uom.getUomModel())) {
			
			  
			  errors.rejectValue("uomModel", null, "uom already exist");
		}
		
		
		                     
	}

}
