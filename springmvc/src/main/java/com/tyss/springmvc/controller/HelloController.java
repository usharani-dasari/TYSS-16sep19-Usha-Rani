package com.tyss.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.springmvc.beans.Employee;

@Controller
public class HelloController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//we have to create customdateeditor to pass this format
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(path="/hello")
	public String hello(@RequestParam("name") String name,
						@RequestParam("id") int id,
						ModelMap map) {
		map.addAttribute("msg","Hello World");
		map.addAttribute("name",name);
		map.addAttribute("id",id);
		return "index";
	}
	
	@RequestMapping(path="/hi/{name}/{id}")
   public  String hi(@PathVariable("name") String name,
		   			@PathVariable("id") int id,
		   			HttpServletRequest req) {
	   req.setAttribute("hi", "Hi usha");
	   req.setAttribute("name", name);
	   req.setAttribute("id", id);
	   return "index";
   }

	//this controller is to get form page.to get the data write one more controller
	@RequestMapping(path = "/form")//if we dont give anything default RequestMethod=doGet()
	public String formPage() {
		return "form";
	}                              //eventhow paths are same,as methods 
	                               //are different for 2 controllers no problem
	
	//to get the form data
	@RequestMapping(path = "/form", method = RequestMethod.POST)//postmapping
	public String form(Employee employee,
						ModelMap map) {
		
		map.addAttribute("id", employee.getId());
		map.addAttribute("name", employee.getName());
		map.addAttribute("password",employee.getPassword());
		map.addAttribute("gender", employee.getGender());
		map.addAttribute("doj", employee.getDoj());
		return "formoutput";
	}
	
	
	//creating cookie is same as servlet.but reading cookie is different
	@RequestMapping(path="create-cookie")
	public String createCookie(ModelMap map,
								HttpServletResponse response) {
		
		Cookie cookie = new Cookie("name" , "Divya");
		response.addCookie(cookie);
		return "createcookie";
	
	}
	
	@RequestMapping(path="/read-cookie")
	public String readCookie(ModelMap map,
								//@CookieValue("name") String name) {if we write this spring
			//will think that u need cookie,so when we try to get cookie even if it is not there throws 400
			//to avoid this do like below
								@CookieValue(name="name",required=false) String name) {
		map.addAttribute("name",name);
		return "readcookie";
	}
	
	@RequestMapping(path = "/redirect")
	public String redirect() {
		return "redirect:https://www.google.com";
		
	}
	
	@RequestMapping(path = "/forward")
	public String forward() {
		return "forward:hi/Giridhar/1";
	}
	
	
//no include over here.Becuase,in MVC the response should be generated in view only.
	//if we use include the response will be generated in controller
	
	
	
}
