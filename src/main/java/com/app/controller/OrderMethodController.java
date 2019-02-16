package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelexport.OrderMethodExcelView;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.validations.OrderMethodValidator;

@Controller
@RequestMapping("/orderMethod")
public class OrderMethodController {

	@Autowired
	private OrderMethodValidator validator ;
		
	
	
	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private OrderMethodUtil util;
	
	//1) show reg page
	@RequestMapping("/ormreg")
	public String showReg(ModelMap map) {
		
		 OrderMethod om= new OrderMethod();
		 
		 map.addAttribute("orderMethod", om);
		
		
		return "OrderMethodRegister";
	}
	//2) save method
	
	@RequestMapping(value="/omsave",method=RequestMethod.POST)
	public String save(@ModelAttribute OrderMethod orderMethod,Errors error,ModelMap map) {
		// add Error class after @modelattribute 
		
		// calling validator
		
            /* validator.validate(orderMethod, error);
		// check for errors
             
		if(error.hasErrors()) 
		{
			
			map.addAttribute("omsave", " check for all erros");
			
			
		}
            else {
				
			
            }
             */
             
		
		//save code
		      Integer id=  service.saveOrderMethod(orderMethod);
		      
		      map.addAttribute("omsave", "data inserted with id :"+id);
		      
		      
		      // extra code + to clean the form form old values
		      
		      
		      map.addAttribute("orderMethod", new OrderMethod());
		      
            
		return "OrderMethodRegister" ;
	}
	
	
	//3)show all method
	
	@RequestMapping("/omviewall")
	public String viewall(ModelMap  map) {
		
		List<OrderMethod> omd=service.getAllOrdermethods();
		
		
		map.addAttribute("vom", omd);
		
		
		return  "OrderMethodData";
	}
	
	// 4) delete method
	
	@RequestMapping("/omdelete")
	public String delete(@RequestParam Integer id,ModelMap map) {

		//delete method
		 service.deleteOrderMethod(id);
		
		 //show reaming data
		 
		 List<OrderMethod> omd=service.getAllOrdermethods();
			
			
			map.addAttribute("vom", omd);
			
			map.addAttribute("dmessage", " deleted record id is  :"+id);
		 
		return  "OrderMethodData";
	}
	
	//5) show one register by id 
	
	@RequestMapping("/omviewone")
	public String viewone(@RequestParam Integer id, ModelMap map) {
		
		      OrderMethod odm= service.getOrderMethodById(id);
		
		map.addAttribute("omviewone", odm);
		
		return "OrderMethodView" ;
	}
	
	//6)load edit page
	
	@RequestMapping("/omeditone")
	public String showEdit(@RequestParam Integer id,ModelMap map ) {
		
		// load row as object
		OrderMethod odm=service.getOrderMethodById(id);
		
		// send it to ui
		map.addAttribute("orderMethod" ,odm );
		
		return "OrderMethodEdit";
	}
	
	
	// 7)do update
	
	@RequestMapping(value="/omupdate", method=RequestMethod.POST )
	public String doupdate(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		
		
		// call service update method
		
		
		service.updateOrderMethod(orderMethod);
		
		// show success message
		
		map.addAttribute("message","orderMethod updated successfully");
		
		// load new data
		
		map.addAttribute("vom", service.getAllOrdermethods());
		
		return "OrderMethodEdit";
	}
	
	
	//excel export
	
	@RequestMapping("/excelexport")
	public ModelAndView doExcelExport() {
		
		               List<OrderMethod> list=service.getAllOrdermethods();
		
		return new ModelAndView(new OrderMethodExcelView(), "list", list);
	}
	
	@RequestMapping("/export")
	public ModelAndView doExcelExportOne(@RequestParam Integer id) {
		
		
		OrderMethod om=service.getOrderMethodById(id);
		
		
		
		return new ModelAndView(new OrderMethodExcelView(),"list", Arrays.asList(om));
	}
	
	// pie chart creation
	
	@RequestMapping("/piecharreport")
	public String generateCharts() {
		
	// getting data from db	
	   List<Object[]> data =	service.getOrderModeTypeCount();
		
	// providing  path to file              
	           
	   
	   String path = context.getRealPath("/");
		
	   
	   // call the generatepie chart mentod form util
	   
	   
	   util.genetatePieChart(path, data);
	   
	   
	   util.createBarChart(path, data);
	   
	   
		return "OrderMethodReport";
		
	}
}
