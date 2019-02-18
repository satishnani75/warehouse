package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelexport.UomExcelView;
import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validations.UomValidator;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	@Autowired
	private UomValidator validator;
	
	@Autowired
	private IUomService service;
	
	@RequestMapping("/uomregister")
	public String showReg(ModelMap map) {
		//extra code
		Uom um= new Uom();
		
		map.addAttribute("uom", um);
		
		
		return "uomRegister";
	}
	
	@RequestMapping(value="/uomreg", method=RequestMethod.POST)
	public String save(@ModelAttribute Uom uom,Errors error, ModelMap map) {
		
		// add Error class after @modelattribute 
		
				// calling validator
				
		     validator.validate(uom, error);
				// check for errors
		             
				if(error.hasErrors()) 
				{
					
					map.addAttribute("msg", " check for all erros");
					
					
				}
		            else {
						
					
		
		       int id= service.saveUom(uom);
		       
		       String message=" date saved and with id:"+id;
		     
	        map.addAttribute("msg",message);
	        
	        //extra code
	        map.addAttribute("uom", new Uom());
	        
		            }
	        
	return "uomRegister";	
	
	
	}
	@RequestMapping("/uall")
	 public String show(ModelMap map) {
		
		List<Uom> msg=service.getAllUoms();
		
		map.addAttribute("ulist", msg);
		
		
		return "UomData";
	}
	@RequestMapping("/udelete")
	public String delete(@RequestParam Integer uid,ModelMap map) {
		//delete row
      service.deleteUom(uid);
		
      
      //show new data
      
      
      List<Uom> msg=service.getAllUoms();
      
      
         map.addAttribute("ulist", msg);
		map.addAttribute("message", " deleted record id is  :"+uid);
		
		
		return "UomData";
	}
	
	@RequestMapping("/viewall")
	public String viewAll(@RequestParam Integer uid,ModelMap map) {
		
		              Uom ds=service.getUomById(uid);
		              
		              map.addAttribute("uall", ds);
		
		return "UomView";
	}
	
	// 6) edit page with data
	
	@RequestMapping("/ueditone")
	public String showEdit(@RequestParam Integer uid,ModelMap map) {
		
		// getting the id from ui and passing it to service metnod
		               Uom st= service.getUomById(uid);
		               
		               // passing uom object to ui
		               
		               map.addAttribute("uom", st);
		
		return "UomEdit";
	}
	
	
	//7) do update data
	
	@RequestMapping(value="/umupdate",method=RequestMethod.POST)
	public String doUpdata(@ModelAttribute Uom uom, ModelMap map) {
		
		
		//call service update
		
		
		service.updateUom(uom);
		
		
		// success message
		
		map.addAttribute("message", "uom update sucessfull");
		
		//get new data
		
		
		map.addAttribute("ulist", service.getAllUoms());
		
		// to to new data
		return "UomEdit";
	}
	
	
	//8 excel export
	
	@RequestMapping("/excelexport")
	public ModelAndView doExcelExport() {
		
            List<Uom> list=service.getAllUoms();
		   
             
		           
		
		return  new ModelAndView(new UomExcelView(), "list", list);
	}
	
	@RequestMapping("/export")
	public ModelAndView doExcelExportone(@RequestParam Integer uid) {
		
		Uom list=service.getUomById(uid);
		
		
		
		
		return new ModelAndView( new UomExcelView() , "list", Arrays.asList(list));
		
		
		
		
	}
	
	}
	
	

