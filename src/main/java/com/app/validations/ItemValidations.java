package com.app.validations;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;
@Component
public class ItemValidations implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return new Item().equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		              Item itm= (Item)target;
		

		      		
		              
	if(!StringUtils.hasText(itm.getItemcode())) {
		
		errors.rejectValue("itemcode", null, "plz enter your item code");
		
	}else if (Pattern.matches("[A-Z]{4,6}", itm.getItemcode())) {
		
	}
		
		
		if(itm.getWidth()!=0 || itm.getWidth()>=1||itm.getWidth()<=100) {
			
			errors.rejectValue("width", null, "plz enter your tiem width b/w 1-100");
			
		}
		
        if(itm.getLength()>=1 || itm.getLength()<=100) {
			
			errors.rejectValue("length", null, "plz enter your item length b/w 1-100");
			
		}


      if(itm.getHeight()>=1 ||  itm.getHeight()<=100) {
	
	errors.rejectValue("height", null, "plz enter your item height b/w 1-100");
	
}


     if (itm.getCost()>=1 ) {

	
	errors.rejectValue("cost", null, "plz enter your item cost b/w 1-100");
}
     
     else if(itm.getCost()<=100) {
    	 errors.rejectValue("cost", null, "plz enter your item cost b/w 1-100");	 
    	 
     }




    if(StringUtils.isEmpty(itm.getBaseCurrency())) {
	
	
	
	errors.rejectValue("baseCurrency", null, " plz select any one base-currency type");
}



  if(!StringUtils.hasText(itm.getDescrep())) {
	
	errors.rejectValue("descrep", null, " plz enter some discription");
}
  /*else if (itm.getDescrep().length()>=10 && itm.getDescrep().length()<=100) {
	
	errors.rejectValue("descrep", null, "plz enter your desc b/w 10-100 letters");
	
}*/

		
	}

}
