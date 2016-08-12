package org.cap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.cap.pojo.Employee;
import org.cap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employeeForm")
	public String showEmployeeForm(ModelMap map){
		//Map<String, Object> map=new HashMap<>();
		map.put("emp", new Employee());
		map.put("deps", getAllDepartments());
		map.put("proj",getAllProject());
		map.put("roles", getAllRole());
		map.put("employees", employeeService.getAllEmployees());
		
		return "employee";
	}
	
	@RequestMapping(value="/empSave",method=RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("emp")Employee employee,
			BindingResult results,ModelMap map){
		//System.out.println(employee);
		map.put("deps", getAllDepartments());
		map.put("proj",getAllProject());
		map.put("roles", getAllRole());
		map.put("employees", employeeService.getAllEmployees());
		if(results.hasErrors()){
			return "employee";
		}else{
		employeeService.saveEmployee(employee);
			return "redirect:employeeForm";
		}
	}
	 @RequestMapping("/edit/{empId}")
	    public ModelAndView editPerson(@PathVariable("empId") Integer employeeId, Model model){
		 	model.addAttribute("employee",new Employee());
	        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
	        model.addAttribute("getAllEmployees()", employeeService.getAllEmployees());
	        model.addAttribute("employee",new Employee());
	        return new ModelAndView("employee");
	 }
	
	
	
	public List<String> getAllDepartments()
	{
		List<String> departs=new ArrayList<>();
		departs.add("Sales");
		departs.add("Purchase");
		departs.add("Finance");
		departs.add("Marketing");
		departs.add("HR");
		departs.add("Training");
		return departs;
	}
	public List<String> getAllProject()
	{
		List<String> pro=new ArrayList<>();
		pro.add("Java");
		pro.add("Mainframe");
		pro.add("Capital Marketing");
		pro.add("Data analytics");
		return pro;
	}
	public List<String> getAllRole()
	{
		List<String> rol=new ArrayList<>();
		rol.add("Developer");
		rol.add("Tester");
		rol.add("consultant");
		return rol;
	}
	
	@RequestMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable("empId") Integer employeeId){
		employeeService.deleteEmployee(employeeId);
		return "redirect:/employeeForm";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
