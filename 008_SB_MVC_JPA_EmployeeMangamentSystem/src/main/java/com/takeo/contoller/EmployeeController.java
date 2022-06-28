package com.takeo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.takeo.binding.Employee;
import com.takeo.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl empService;

	@RequestMapping("/loadForm")
	public String loadForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("emp", emp);

		return "employee";
	}

	@RequestMapping(value = "/empInsert", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("emp") Employee emp, Model model) {
		boolean saveEmployee = empService.saveEmployee(emp);
		String msg = "";
		if (saveEmployee) {
			msg = "Employee Record Saved Successfully";
		} else
			msg = "Employee Record not Inserted";

		model.addAttribute("msg", msg);

		return "employee";
	}

	@GetMapping("/viewEmployees")
	public String viewAllEmployees(Model model) {
		List<Employee> allEmployees = empService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return "viewEmployees";
	}

	@RequestMapping(value = "/editemp")
	public String edit(@RequestParam int id, Model m) {
		Employee emp = empService.getEmpById(id);
		System.out.println(emp.getEno() + "\t" + emp.getEname() + "\t" + emp.getEadd());
		m.addAttribute("employee", emp);
		return "empeditform";

	}

	// It updates model object.

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("student") Employee employee, Model model) {
		System.out.println("updateing " + employee.getEno() + "\t" + employee.getEname() + "\t" + employee.getEadd());
		boolean isSaved = empService.updateEmployee(employee);
		String msg = "";
		System.out.println("welcome for updating" + isSaved);
		if (isSaved) {
			msg = "Employee Updated Successfully";
		} else {
			msg = "Failed to Updated Record";
		}
		model.addAttribute("msg", msg);

		return "redirect:/viewEmployees";

	}

	@RequestMapping(value = "/deleteemp")
	public String delete(@RequestParam int id, Model m) {
		System.out.println("Welcome boss to delete" + id);
		empService.deleteEmployee(id);

		return "redirect:/viewEmployees";
	}

}
