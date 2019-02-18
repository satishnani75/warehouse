package com.app.validations;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Component
public class ShipmentTypeValidator implements  Validator{

	@Autowired
	private IShipmentTypeService service;
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return new ShipmentType().equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		ShipmentType sh= (ShipmentType)target;
		
		             
		if(Pattern.matches("[A-Z] {4,6}", sh.getShipmentCode())) {
			
			
			errors.rejectValue("shipmentCode", null,"enter valid shipment code");
		}else if (service.isShipmentCodeExist(sh.getShipmentCode())) {
			
		}
		
		
		// shipmemt mode validation for  drop down
		
		
		if(StringUtils.isEmpty(sh.getShipmentMode())) {
			
			errors.rejectValue("shipmentMode", null, "select any one of the mode from list");
		}
	
	
		
		//  shipmentmode text box validaton
		
		
		if(!StringUtils.hasText(sh.getShipmentCode())) {

			errors.rejectValue("shipmentCode", null, " plz enter your shipment-code ");
			
			
		}
		
		
		
		
		
		
	}
	
	
	

}
