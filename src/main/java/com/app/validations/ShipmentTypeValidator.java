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
		
		             
		
		
		
		// 1) shipmemt mode validation for  drop down
		
		
		if(StringUtils.isEmpty(sh.getShipmentMode())) {
			
			errors.rejectValue("shipmentMode", null, "select any one of the mode from list");
		}
	
	
		
		// 2) shipmentcode  text box validaton
		
		
		if(!StringUtils.hasText(sh.getShipmentCode().trim())) {

			errors.rejectValue("shipmentCode", null, " plz enter your shipment-code ");
			
			
		}else if (!Pattern.matches("[A-Z]{4,6}", sh.getShipmentCode())) {
			
			
			errors.rejectValue("shipmentCode", null, "your shipment code should contaion 4-6 upper cases letters");
		}else if (service.isShipmentCodeExist(sh.getShipmentCode())) {
		
			
			errors.rejectValue("shipmentCode", null, "shipment code already exist");
		}
		
		
		// 3)enable shipment drop down validations (yes/no)
		
		
		
		if(StringUtils.isEmpty(sh.getEnableShipment())) {
			
			errors.rejectValue("enableShipment", null, "plz enable ur shipment with yes or no ");
		}
		
		// 4)shipment grade (radio button) a or b or c ?
		
		
		if(StringUtils.isEmpty(sh.getShipmentGrade())) {
			
			errors.rejectValue("shipmentGrade", null, "plz select any grade from above");
			
		}
		
		
		
		//5)desc validaton (10 - 100 chars in it)
		
		
		if (!StringUtils.hasText(sh.getShipdesc().trim())) {
			
			errors.rejectValue("shipdesc", null, "plz enter shipment description");
			
			
			
		}
	}
	
	
	

}
