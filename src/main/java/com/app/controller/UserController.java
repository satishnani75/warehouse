package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelexport.UserExcelView;
import com.app.mail.EmailUtill;
import com.app.model.User;
import com.app.service.IUserService;
import com.app.validations.UserValidations;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserValidations validator;
	
	@Autowired
	private EmailUtill emailUtil;
	
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;


	@Autowired
	private IUserService service;

	@RequestMapping("/reg")
	public String showReg(ModelMap map) {

		map.addAttribute("userObj", new User());

		return "UserRegister";
	}

	// saving data
	@RequestMapping(value="/insert" , method=RequestMethod.POST)
	public String saveUserData(@ModelAttribute User userObj, Errors error, ModelMap map ) {


		
		validator.validate(userObj, error);
		
		if(error.hasErrors()) {
			
			error.rejectValue("savemessage", null, "please check all your errors ");
			
		}else {
			
			
		String pwd= userObj.getPwd();
	
			int id=service.saveUser(userObj);
			
			String message = userObj.getUname()+" save with id  :" + id;

			
			
          String text = " hello !" + userObj.getUname() + " , your user name is : "+ userObj.getEmail() + 
        		  
        		  " , password is "+pwd + " role are : "+userObj.getRoles() ;
			

          boolean flag = emailUtil.sendEmail(userObj.getEmail(), "welcome to user :", text);
          
          
          if (flag) {
        	  
        	  message= " email succesfully sent";
          
			
		}else {
			
			message= " eamil is not sent ";
			
			
		}
          
          
          // email end 
          
		map.addAttribute("savemessage", message);
		
		
		}
		
		// clearing reg page

		map.addAttribute("userObj", new User());
		

		return "UserRegister";
	}


	// view all data

	@RequestMapping("/viewall")
	public String viewAllData(ModelMap map) {

		List<com.app.model.User> list=service.getAllUsers();

		map.addAttribute("list", list);				


		return "UserData";
	}


	//view one record
	@RequestMapping("/viewone")
	public String viewOneRec(@RequestParam Integer uid,ModelMap map) {

		com.app.model.User user=service.getUserById(uid);


		map.addAttribute("listone", user);
		return "UserDataView";

	}

	//delete 

	@RequestMapping("/delete")
	public String deleteOne(@RequestParam Integer uid,ModelMap map){

		service.deleteUser(uid);


		map.addAttribute("deletemessage"," you have successfully deleted id :"+uid);



		map.addAttribute("list", service.getAllUsers());

		return "UserData";

	}



	//show edit page

	@RequestMapping("/showedit")
	public String showEditPage(@RequestParam Integer uid,ModelMap map) {

		com.app.model.User uh=service.getUserById(uid);

		map.addAttribute("userEdit",uh);


		return "UserEdit";
	}


	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUserData(@ModelAttribute User userEdit,ModelMap map) {


		service.updateUser(userEdit);


		map.addAttribute("updatemessage", "your data updated successfull");

		map.addAttribute("list", service.getAllUsers());      

		return "UserEdit" ;
	}

	// excel view all
	@RequestMapping("/excelexport")
	public ModelAndView excelExportUser() {

		List<com.app.model.User> list =	service.getAllUsers();


		return new ModelAndView(new UserExcelView(), "list", list);

	}

}
