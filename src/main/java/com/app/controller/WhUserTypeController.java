package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelexport.WhUserTypeExcelView;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	
	@RequestMapping("/reg")
	public String showRegpage(ModelMap map) {
		map.addAttribute("whuserType", new WhUserType());
		
		
		return "WhUserTypRegister" ;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveWhUser(@ModelAttribute WhUserType whuserType , ModelMap map) {
		
		int id=service.saveWhUserType(whuserType);
		
		String msg= "your data saved with id :"+id;
		
		map.addAttribute("insertmessage", msg);
		
		map.addAttribute("whuserType", new WhUserType());
		return "WhUserTypRegister";
	}
		//3 view all
	
	
	@RequestMapping("/viewall")
	public String viewall(ModelMap map) {
		
		        List<WhUserType> list= service.getAllWhUserTypes();
		
		        map.addAttribute("listall", list);
		        
		        
		return "WhUserTypeData" ;
	}
	
	//4) delete a record
	
	@RequestMapping(value="/delete")
	public String deleteOne(@RequestParam Integer wid,ModelMap map) {
		
		service.deleteWhUserType(wid);
		
		map.addAttribute("listall", service.getAllWhUserTypes());
		
		map.addAttribute("deletemessage", " you have successfully deleted  id :"+wid);
		
		return "WhUserTypeData" ;
		
		
		
	}
	
	
	//5)view one
	
	@RequestMapping("/viewone")
	public String viewOne(@RequestParam Integer wid,ModelMap map) {
		
	WhUserType wh=service.getWhUserTypeById(wid);
	
	map.addAttribute("vone", wh);
	
		
		return "WhUserTypeViewone";
	}
	
	
	//6 edit
	
	@RequestMapping("/showedit")
	public String showEdit(@RequestParam Integer wid,ModelMap map) {
		
		     WhUserType wt=service.getWhUserTypeById(wid);
		
		     
		     map.addAttribute("whuserType",wt);
		     
		
		return "WhuserTypeEdit";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePage(@ModelAttribute WhUserType whuserType,ModelMap map ) {
		
		service.updateWhUserType(whuserType);
		
		map.addAttribute("updatemessage","update successfull");
		
		//get new data
		
		
		map.addAttribute("listall", service.getAllWhUserTypes());
		
		return "WhuserTypeEdit";
	}
	
	
	// excel export
	
	@RequestMapping("/excelexport")
	public ModelAndView exportAll() {
		
		                 List<WhUserType> wlist=service.getAllWhUserTypes();
		
		return new ModelAndView(new WhUserTypeExcelView(), "list", wlist);
	}
	
	@RequestMapping("/exportone")
	public ModelAndView exportOne(@RequestParam Integer wid) {
		
	
		
              WhUserType wh2 =		service.getWhUserTypeById(wid);
		
		return new ModelAndView( new WhUserTypeExcelView(), "list", Arrays.asList(wh2));
	}
	
}
