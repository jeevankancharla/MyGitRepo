package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.dao.EmployeeDAO;
import com.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	 EmployeeService service;

	@GetMapping("/empLogin")
	public String getLogin() {

		return "loginFormEmp";

	}

	@PostMapping("/empLogin")
	public String authentictae(int id, String pwd, HttpServletRequest request, ModelMap map) {

		EmployeeBean bean = service.authenticate(id, pwd);

		if (bean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", bean);
			return "homePage";
		} else {
			map.addAttribute("errmsg", "invalid crenditials");
			return "loginFormEmp";
		}

	}// end of authenticate
	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {
		
		if(session.getAttribute("emp")!= null) {
			return "searchForm";
		}else {
			map.addAttribute("errMsg", "please login");
			return "loginFormEmp";
		}
		
	}//end of getSearchform
	@GetMapping("/search")
	public String searchEmp(int id ,ModelMap map, @SessionAttribute(name = "emp",required = false) EmployeeBean bean) {
		
		
		if(bean != null) {
			EmployeeBean bean2 = service.getEmployee(id);
			if(bean2 != null) {
				map.addAttribute("data" , bean2);
			}else {
				map.addAttribute("msg", "data not found for id"+id);
			}
			return "searchForm";
		}else {
			map.addAttribute("errMsg", "please login first");
			return "loginFormEmp";
		}
		
		
	}//end of search emp

	@GetMapping("/logout")
	public String logout(HttpSession session , ModelMap map) {
		
		session.invalidate();
		map.addAttribute("msg", "Logout Successfull");
		return "loginFormEmp";
		
	}// end of logout
	
	
	@GetMapping("/deleteEmp")
	public String showDeleteForm(HttpSession session, ModelMap map) {
		if(session.getAttribute("emp") != null) {
			return "deleteForm";
		}else {
			map.addAttribute("errMsg", "please login");
			return "loginFormEmp";
		}
	}
	
	@GetMapping("/delete")
	public String deleteEmp(int id, @SessionAttribute(name = "emp" ,required = false) EmployeeBean bean   , ModelMap map) {
		
		if(bean != null) {
			boolean data = service.deleteEmp(id);
			if(data ) {
				
			map.addAttribute("data", "data deleted");		
			}else {
			map.addAttribute("msg", "data not found");
			
		}
		return "deleteForm";
	}else {
			
			map.addAttribute("errmsg", "Logout Successfull");
			return "loginFormEmp";
		}
		
	}
	
}
