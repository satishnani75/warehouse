package com.app.controller;


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

import com.app.excelexport.PurchaseOrderExcepExp;
import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhuserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private IShipmentTypeService shipmentService;
	
	@Autowired
	private IWhUserTypeService whuService;
	
	@Autowired
	private IPurchaseOrderService service;
	

	
	@RequestMapping("/reg")
	public String showRegPage(ModelMap map ) {
			map.addAttribute("purchaseOrder", new PurchaseOrder());
		//shipment integration
			List<ShipmentType> list =  shipmentService.getAllShipments();
			
			   
			   map.addAttribute("shipment", list);
			  
			   // whuser integration 
			   
	        List<WhuserType> wlist = whuService.getAllWhUserTypes();		   
			   
	                     
	        map.addAttribute("whusr", wlist);             
				
		return "PurchserOrderRegister";
	}
	
	//save porder
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePorder(@ModelAttribute PurchaseOrder purchaseOrder, Errors error,ModelMap map) {
		
		      int id=service.savePurchaserOrder(purchaseOrder);
		
		map.addAttribute("savemessage", "your data saved successfully id ="+id);
		
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		
		
		//shipment type integrations
		
		   List<ShipmentType> list =  shipmentService.getAllShipments();
		
		   
		   map.addAttribute("shipments", list);
		   
		   // whuser integration
		   
		   List<WhuserType> wlist = whuService.getAllWhUserTypes();		   
		   
           
	        map.addAttribute("whusr", wlist);  
		
		return "PurchserOrderRegister";
	}
	
	@RequestMapping("/delete")
	public String deletePorder(@RequestParam Integer id,ModelMap map) {
		
		
		      service.deletePurchaserOrder(id);
		
		      map.addAttribute("deletemessage", "you have deleted data with id :"+id);
		
		      
		      map.addAttribute("porder", service.getAllPurchases());
		      
		      
		return "PurchseOrderData" ;
		
		
	}
	
	@RequestMapping("/showall")
	public String showAll(ModelMap map) {
		
		
		    List<PurchaseOrder> list=service.getAllPurchases();
		
		
		    map.addAttribute("porder", list);
		    
		return "PurchseOrderData";
		
		
	}
	
	
	// edit and update
	
	
	@RequestMapping("/showedit")
	public String editOne(@RequestParam Integer id,ModelMap map) {
		
	          PurchaseOrder p =	service.getOnePurchaserOrder(id);
		
		       map.addAttribute("editone", p);
	          
	          
	          
	return "ShowEditPage";	
		
		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public String updateOrder(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map) {
		
		    service.updatePurchaserOrder(purchaseOrder);
		
		map.addAttribute("update", "your data successfully updated");
		
		return "ShowEditPage";
		
	}
	
	//excel export
	@RequestMapping(value="/excelexport",method=RequestMethod.POST)
	public ModelAndView excelExpAll(@ModelAttribute PurchaseOrder porder) {
		
		    List<PurchaseOrder> orders=service.getAllPurchases();
		
		return new ModelAndView( new PurchaseOrderExcepExp(), "list",orders);
	}
	
	
	
	
	
	
}
