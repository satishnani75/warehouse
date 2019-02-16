package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelexport.ItemExcelExport;
import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.pdfexport.ItemPdfExport;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IUomService uomService;

	@Autowired
	private IOrderMethodService odmService;

	@Autowired
	private IItemService service;

	/*@Autowired
	private ItemValidations validator;
*/
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {



	//	Item itm = new Item();


		map.addAttribute("item", new Item());

		Map<Integer, String> mapdata=uomService.getUomIdandName();

		map.addAttribute("uoms", mapdata);
		
		 List<OrderMethod> olist=odmService.getAllOrdermethods();
         
         map.addAttribute("odms", olist);

		return "ItemRegistration";
	}

	@RequestMapping(value="/saveitem",method=RequestMethod.POST)
	public String  saveItem(@ModelAttribute Item item,Errors error,ModelMap map) {


		// validations

		/*validator.validate(item, error);


		if(error.hasErrors()) {

		map.addAttribute("savemessage", " plz check  ");


		}else {
		 */

		int id=service.saveItem(item);

		map.addAttribute("savemessage", "your data saved with id :"+id);  

		//uom intigration
		/*List<Uom> ulist=uomService.getAllUoms();

		map.addAttribute("uoms", ulist);*/

		
		// loading only id and uommodel
		
		Map<Integer, String> mapdata=uomService.getUomIdandName();

		map.addAttribute("uoms", mapdata);
		
		// ordermethod integration
		
		
		         List<OrderMethod> olist=odmService.getAllOrdermethods();
		         
		         map.addAttribute("odms", olist);
		         
		         
		         // 
		         
		// to clean the form

		map.addAttribute("item", new Item())  ;      




		return "ItemRegistration";
	}


	@RequestMapping("/showall")
	public String showAllItems(@ModelAttribute Item item,ModelMap map) {

		List<Item> list=service.getAllItems();

		map.addAttribute("list", list);


		return "ItemData";


	}


	@RequestMapping("/deletitem")
	public String deleteItem(@RequestParam Integer sid ,ModelMap map) {

		service.deleteItem(sid);


		map.addAttribute("deletemsg", " your data deleted successfuly  with id :"+sid);

		map.addAttribute("list",service.getAllItems());


		return "ItemData";


	}



	@RequestMapping("/getone")
	public String viewOne(@RequestParam Integer id,ModelMap map) {


		Item item =   service.getItemById(id);


		map.addAttribute("viewone", item);



		return "ItemData";
	}

	// pdf export


	@RequestMapping("/pdfexport")
	public ModelAndView doPdfExportall() {

		List<Item> list=service.getAllItems();


		return new ModelAndView(new ItemPdfExport(), "list", list);
	}


	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		//reading data from DB
		List<Item> list =  service.getAllItems();

		//view, key,val
		return new ModelAndView(
				new ItemExcelExport(), "list", list);
	}


	//edit page
	@RequestMapping("/edititem")
	public String showEditPage(@RequestParam Integer id,ModelMap map) {
		// load the edit object
	   Item itm=service.getItemById(id);
	   
	   
	   // loading uom object into item edit page
	   
	   Map<Integer, String> mapdata=uomService.getUomIdandName();

		map.addAttribute("uoms", mapdata);
		
	   // pass it to edit page ui
	   
		map.addAttribute("item", itm);
		
	   
	   
		return "ItemEditpage";
	}
	
	@RequestMapping(value="/updateitem" , method=RequestMethod.POST)
	public String updatePage(@ModelAttribute Item item,ModelMap map) {
		
		        // load obj form ui
		         service.update(item);
		         
		  map.addAttribute("updatemsg", "update success full ");
		  
		  map.addAttribute("list", service.getAllItems());
		  
		         
		return "ItemEditpage";
	}
	
	
	

}
