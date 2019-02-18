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

import com.app.excelexport.ShipmentTypeExcelView;
import com.app.model.ShipmentType;
import com.app.pdfexport.ShipmentTypePdfView;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtill;
import com.app.validations.ShipmentTypeValidator;

@Controller
@RequestMapping("/shipmetType")
public class ShipmentTypeController {
	
	
	@Autowired
	private ShipmentTypeValidator validator;

	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private ShipmentTypeUtill shiputil;

	@RequestMapping("/shipment") 
	public String showReg(ModelMap map) {

		ShipmentType ss= new ShipmentType();

		map.addAttribute("shipmentType", ss);

		return "ShipmentTypeRegister";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save( @ModelAttribute ShipmentType shipmentType,Errors error ,ModelMap map) {

		
		validator.validate(shipmentType, error);
		
		if(error.hasErrors()) {
			
			map.addAttribute("message", " plase check for all errors");
		}
		else {
		int id= service.saveShipmentType(shipmentType);

		String msg= " saved with id :"+id;

		//extra code 

		
		map.addAttribute("message", msg);
		map.addAttribute("shipmentType", new ShipmentType());
		}


		


		return "ShipmentTypeRegister" ;
	}


	@RequestMapping("/all")
	public String viewall(ModelMap map) {

		List<ShipmentType> obs=service.getAllShipments();

		map.addAttribute("list", obs);


		return "ShipmentTypeData";
	}


	@RequestMapping("/delete")
	public String delete(@RequestParam Integer sid,ModelMap map) {
		//delete row
		service.deleteShipmentType(sid);


		//show new data


		List<ShipmentType> obs=service.getAllShipments();


		map.addAttribute("list", obs);
		map.addAttribute("message", "record deleted :"+sid);


		return "ShipmentTypeData";
	}

	//viewone record
	@RequestMapping("/viewone")
	public String viewone(@RequestParam Integer sid,ModelMap map ) {

		ShipmentType sp=service.getShipmentTypeBYId(sid);

		map.addAttribute("vone", sp);


		return "ShipmentTypeView";
	}

	// show edit page with data


	@RequestMapping("/editone")
	public String showEdit(@RequestParam Integer sid,ModelMap map) {

		//load row  as object

		ShipmentType sk=service.getShipmentTypeBYId(sid);

		// send it to ui
		map.addAttribute("shipmentType", sk);

		return "ShipmentTypeEdit";
	}


	//7) do update data

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		// call service update

		service.updateShipmentType(shipmentType);

		// write success update message

		map.addAttribute("message", " shipmentType updated");

		//    get new data


		map.addAttribute("list", service.getAllShipments());


		// goto new data

		return "ShipmentTypeEdit" ;
	}


	//8. Export Data to Excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		//reading data from DB
		List<ShipmentType> list =  service.getAllShipments();

		//view, key,val
		return new ModelAndView(
				new ShipmentTypeExcelView(), "list", list);
	}

	//8. Export Data to Excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer sid) {
		//reading data from DB
		ShipmentType st=service.getShipmentTypeBYId(sid);
		//view, key,val
		return new ModelAndView(
				new ShipmentTypeExcelView(), 
				"list", Arrays.asList(st));
	}

	// pdf export all records

	@RequestMapping("/pdfexport")
	public ModelAndView doPdfExportall() {

		List<ShipmentType> list=service.getAllShipments();


		return new ModelAndView(new ShipmentTypePdfView(), "list", list);
	}


	//pdf export one record

	@RequestMapping("/pdfone")
	public ModelAndView doPdfExportOne(@RequestParam Integer sid) {

		ShipmentType list=service.getShipmentTypeBYId(sid);



		return new ModelAndView(new ShipmentTypePdfView(),"list",Arrays.asList(list));
	}



	// pie chart creation

	@RequestMapping("/piechartdata")
	public String generateCharats() {

		List<Object[] > data = service.getShipmentTypeByName();

		String path=context.getRealPath("/");

		shiputil.generatePieChart(path, data);

		shiputil.createBarChart(path, data);

		return "ShipmentModePieChart";
	}
}
