package it.antoniop.springdatajpa.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import it.antoniop.springdatajpa.exception.RecordNotFoundException;
import it.antoniop.springdatajpa.model.EmployeeEntity;
import it.antoniop.springdatajpa.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeMvcController {
	
	static final Logger LOG = LoggerFactory.getLogger(EmployeeMvcController.class);
	
	
	@Value("${app.message}")
	private String welcomeMessage;

	
	@Autowired
	EmployeeService service;

	@RequestMapping
	public String getAllEmployees(Model model) {
		List<EmployeeEntity> list = service.getAllEmployees();
		if (LOG.isInfoEnabled()) {
			LOG.info(String.format(" getAllEmployees() is saying [%s]", welcomeMessage));
		}
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("employees", list);
		// //
		return "list-employees";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
		if (id.isPresent()) {
			EmployeeEntity entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} //
		else {
			model.addAttribute("employee", new EmployeeEntity());
		}
		// //
		return "add-edit-employee";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return "redirect:/";
	}

	// @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	@PostMapping(path = "/createEmployee")
	public String createOrUpdateEmployee(EmployeeEntity employee) throws RecordNotFoundException {
		service.createOrUpdateEmployee(employee);
		return "redirect:/";
	}
}
