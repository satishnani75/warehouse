package com.app.validations;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements Validator


{

	@Override
	public boolean supports(Class<?> clazz) {
		
		
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//convert to model class object
		       OrderMethod odm     = (OrderMethod )target;
		
		
		//radio button validation -order mode {sale or purchase }
		
		if(StringUtils.isEmpty(odm.getorderMode())) {
			
			errors.rejectValue("orderMode", null, "please select any one option");
			
		}
		
		// text input 
		// empty check + pattern check 
		
		
		if((!StringUtils.hasText(odm.getOrderCode()))){
			
			errors.rejectValue("orderCode", null, "plese enter your order code");
			
			
		}  else if (!Pattern.matches("[A-Z]{4,6}", odm.getOrderCode())) {
			
			
			errors.rejectValue("orderCode", null, "your code must contaion 4-6 upper cases only");
			
		} 
		
		
		// DROP DOWN EMPTY CHECK
		
		if(StringUtils.isEmpty(odm.getExeType())) {
			
			errors.rejectValue("exeType", null, "plz select one option");
			
		}
		
		
		//check box list -size >=1 
		
		if(odm.getOrderAccept()==null || odm.getOrderAccept().isEmpty()) {
			
			errors.rejectValue("orderAccept", null, "plz select one or more options");
			
			
		}
		
		// check discription has text or it should had 10 -100 chars inside it
		
		
		if(!StringUtils.hasText(odm.getOrderDesc().trim())) {
			
			errors.rejectValue("orderDesc", null, "plz enter your discription");
			
			
		}else if(odm.getOrderDesc().length()<10 || odm.getOrderDesc().length()>100) {
			
			
			errors.rejectValue("orderDesc", null, " your text should be b/w 10 -100 char only");
		}
		
		
	}

}
