package EmployeeJDBCConnectivity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @RestController
	public class EmployeeController {
	@Autowired
	EmployeeDao eDAO;

	@GetMapping("/getall")
	public List<Employee> findAll() {	
	return eDAO.findAll();
	}

	@GetMapping("/getid/{id}")
	public String findById(@PathVariable int id) {
	eDAO.findById(id);
	return "Success";
	}
	@DeleteMapping(value="/employee/{id}")
	public String deleteById(@PathVariable int id) {
	return eDAO.deleteById(id)+" Deleted Successfully";
	}

	@PostMapping(value="/post")
	public String save(@RequestBody Employee e) {
	      eDAO.save(e);
	return " Saved successfully";
	}
	@PutMapping(value="/get/{id}")
	public String update(@RequestBody Employee e, @PathVariable int id) {
	return eDAO.update(e, id)+" Employee(s) updated successfully";
	}
	}


