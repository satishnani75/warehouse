package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {

	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("showall")
	public ResponseEntity<?> showall(){
		
		ResponseEntity<?> response= null;
		
		List<ShipmentType> shipment=service.getAllShipments();
		
		
		if(shipment!=null && !shipment.isEmpty()) {
			
			response=new ResponseEntity<List<ShipmentType>>(shipment, HttpStatus.OK);
		}
		else {
			response= new ResponseEntity<String>(" data not avilable",HttpStatus.OK);
		}
		
		
		return response;
		
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> showOne(@PathVariable Integer id){
		
		ResponseEntity<?> rs= null;
		
	                ShipmentType st =  service.getShipmentTypeBYId(id);
		
	                if(st!=null) {
	                	
	                	
	                	rs= new ResponseEntity<ShipmentType>(st, HttpStatus.OK);
	                	
	                }else {
	                	
	                	
	                	rs=new ResponseEntity<String>("data not found", HttpStatus.BAD_REQUEST);
	                	
	                }
	                
		return rs;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable Integer id){
		
		
		ResponseEntity<String> rs = null;
		
		try {
		
		service.deleteShipmentType(id);
		
		rs= new ResponseEntity<String>("deleting of  successful", HttpStatus.OK);
		
		}catch (Exception e) {
			
			rs= new ResponseEntity<String>("id not exist", HttpStatus.BAD_REQUEST);
			
		}
		
		return rs;
		
	}
	
	
	
	
	
	
	
	
}
