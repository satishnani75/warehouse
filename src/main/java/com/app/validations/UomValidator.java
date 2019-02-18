package com.app.validations;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.ctc.wstx.util.StringUtil;

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
		                     
		  if(Pattern.matches("[A-Z]  {4,6}  ", uom.getUomModel()))   {
			  
			  errors.rejectValue("uomModel", null, "enter valid uom  ");
			  
			  
		  }else if (service.isUomModelExist(uom.getUomModel())) {
			
			  
			  errors.rejectValue("uomModel", null, "uom already exist");
		}
		
		
		  // uom type validation
		  
		  
		  if(StringUtils.isEmpty(uom.getUomType()) ) {
			  
			  errors.rejectValue("uomType", null, " plz select any one option");
			  
		  }
		  
		  
		  // uom model validator text input validator
		  
		  
		  if(!StringUtils.hasText(uom.getUomModel())) {
			  
			  errors.rejectValue("uomModel", null, "enter your model details");
			  
			  
		  }else if (!Pattern.matches("[A-Z]{4,6}", uom.getUomModel())) {
			  errors.rejectValue("uomModel", null, "plz enter 4-6 upper cases in model ");
			  
			
		}
		  
		  // desc validations
		  
		 
		  
		  /*if(!StringUtils.hasText(uom.getDsc()) ){
			  
			  errors.rejectValue("dsc", null, " enter some description");
			  
		  }else if (uom.getDsc().length()<=50 && uom.getDsc().length()>=10) {
			
			  
			  errors.rejectValue("dsc", null, " chars must be 10 to 50 only");
		}
		  */
		  
	}

}
