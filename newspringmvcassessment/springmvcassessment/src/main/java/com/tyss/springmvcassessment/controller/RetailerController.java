package com.tyss.springmvcassessment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tyss.springmvcassessment.dto.Product;
import com.tyss.springmvcassessment.dto.RetailerBean;
import com.tyss.springmvcassessment.service.RetailerService;

@Controller
public class RetailerController {
	
	@Autowired
	private RetailerService service;
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
		
	}
	
	@PostMapping("/login")
	public String login(int id,String password,HttpServletRequest request) {
		RetailerBean bean = service.login(id, password);
		//if bean==null =>InvalidCredintials
		if(bean==null) {
			request.setAttribute("msg", "Invalid Credentials");
			return "login";
			
		}else {
			HttpSession session = request.getSession();//getSession()=getSession(true)
			session.setAttribute("bean", bean);
					return "home";
		}
		
	}//end of login()
	
	@GetMapping("/createprofile")
	public String createProfilePage() {
		return "createprofile";
	}//end of createProfilePage()
	
	
	@PostMapping("/createprofile")
	public String register(RetailerBean bean,ModelMap map) {
		
		int check = service.createProfile(bean);
		if(check>0) {
			map.addAttribute("msg", "You have created ur profile successfully and ID is "+check);
		}else {
			map.addAttribute("msg","Email is Repeated");
		}
		
		return "login";
		
	}//end of createProfile()
	
	@GetMapping("/home")
	public String home(ModelMap map,
			@SessionAttribute(name = "bean", required=false) RetailerBean bean) {
		
		if(bean==null) {
			map.addAttribute("msg","Login First!!!!!");
			return "login";
		}else {
		return "home";
		}
	}//end of home()
	
	@PostMapping("/home")//since it is postmapping i really know it is logged in no need to check.if it is @GetMapping =>i need to check
	public  String home() {
		return "home";
	}//end of home()
	
	
	@GetMapping("/search")
	public String search(@RequestParam("pid") int pid,
			ModelMap map) {
		Product product = service.search(pid);
		if(product==null) {
			map.addAttribute("msg","product Not Found");
			
			
		}else {
			map.addAttribute("product", product);
		}
		return "home";
	}//search()
	
	@GetMapping("/updatepassword")
	public String changePassword(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session!=null) {
			return "updatepassword";
		}else {
		return "login";
		}
	}
	
	@PostMapping("/updatepassword")
	public String changePassword(String password,
			String confirmpassword,
			@SessionAttribute(name="bean")RetailerBean bean,
			ModelMap map) {
		if(password.equals(confirmpassword)) {
			service.updatePassword(bean.getId(),password);
			map.addAttribute("msg","Password Changed");
			
		}else {
			map.addAttribute("msg", "Password Not Matching");
			
		}
		return "home";
	
	}//
	
//	@GetMapping("/getorder")
//	public String getOrder(String pid,HttpServletRequest req) {
//		
//		HttpSession session = req.getSession(false);
//		
//		
//		
//		
//		
//	}//
//	
	@PostMapping("/doorder")
	public String doOrder(int pid,
			int quantity,
			ModelMap map,HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		RetailerBean bean = (RetailerBean)session.getAttribute("bean");
	
		boolean check = service.doOrder(pid,quantity,bean.getId());
		if(check) {
			map.addAttribute("msg", "ur order placed successfully");
			
		}else {
			map.addAttribute("msg", "order not placed");
			
		}
		return "home";
	}

}
