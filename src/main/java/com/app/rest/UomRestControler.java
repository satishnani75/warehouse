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

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestControler {

	@Autowired
	private IUomService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
		ResponseEntity<?> response = null;
		
		       List<Uom> uoms=service.getAllUoms();
		       
		      
		
		      if(uoms!=null && !uoms.isEmpty()) {
		    	  
		    	  response= new ResponseEntity<List<Uom>>(uoms, HttpStatus.OK);
		      }else {
				
		    	  response= new ResponseEntity<String>(" data not vaialble ",HttpStatus.OK);
			}
		
		
	return response;	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable Integer id) {
		
		ResponseEntity<String> rs= null;
		
		try {
			
			service.deleteUom(id);
			
			rs= new ResponseEntity<String>("delete succss full", HttpStatus.OK);
			
			
			
		}catch (Exception e) {
			
			
			rs= new ResponseEntity<String>("data not found", HttpStatus.BAD_REQUEST);
		}
		
		
		return rs;
	}
	
	
}
