package com.app.validations;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

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
		
		             
		if(Pattern.matches("[A-Z] {4.6 }", sh.getShipmentCode())) {
			
			
			errors.rejectValue("shipmentCode", null,"enter valid shipment code");
		}else if (service.isShipmentCodeExist(sh.getShipmentCode())) {
			
		}
		
		
	}
	
	
	

}
