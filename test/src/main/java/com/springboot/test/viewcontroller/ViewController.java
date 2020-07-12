package com.springboot.test.viewcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.test.dao.EmployeeDAO;
import com.springboot.test.model.Employee;
import static javax.swing.JOptionPane.showMessageDialog;

import java.security.Principal;

import javax.swing.JOptionPane;

@Controller
public class ViewController {

	@Autowired
	EmployeeDAO employeeDAO;
	@Autowired
	Employee employee;

	/* getting all employees on homePage */
	@GetMapping({ "/", "/home", "/index" })
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home.jsp");
		mv.addObject("employees", employeeDAO.getEmployees());
		return mv;
	}

	/*
	 * It displays a form to input data, here "employee" is a reserved request
	 * attribute which is used to display object data into form otherwise getting
	 * error Neither BindingResult nor plain target object for bean name 'employee'
	 * available as request attribute
	 */
	@RequestMapping("/add")
	public String showform(Model m) {
		m.addAttribute("employee", new Employee());
		return "add_employee.jsp";
	}

	/* adding new employee */
	/*
	 * getting Neither BindingResult nor plain target object available as request
	 * attribute error adding modelAttribute for solution
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addingEmployee(@Valid @ModelAttribute("employee") Employee employee) {
		if (employee.getHireDate().getYear() - employee.getDob().getYear() > 18) {
			employeeDAO.addEmployee(employee);
			return "redirect:/home";
		} else {
			return "error.jsp";
		}
	}

	/*
	 * update or edit employee using @PathVariable getting 404 error because of
	 * /update/{id} -> / slash causing 404 error
	 */
	@RequestMapping(value = "/update{id}")
	public String updateEmployee(@PathVariable("id") Long employeeId, Model model) {
		Employee emp = employeeDAO.getEmployee(employeeId);
		model.addAttribute("editEmployee", emp);
		return "update_employee.jsp";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public String editsave(@Valid @ModelAttribute("editEmployee") Employee employeeDetails,
			BindingResultUtils bindingResult) {
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setDob(employeeDetails.getDob());
		employee.setHireDate(employeeDetails.getHireDate());
		employee.setSsn(employeeDetails.getSsn());
		employeeDAO.addEmployee(employee);

		return "redirect:/home.jsp";
	}

	/* Deleting employees */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String deletingEmployee(@PathVariable("id") Long employeeId) {
		employeeDAO.deleteEmployeeById(employeeId);
		return "redirect:/home";
	}

	/* oAuth2 */
	/*
	 * @RequestMapping("user")
	 * 
	 * @ResponseBody public Principal user(Principal principal) { return principal;
	 * }
	 */
}
