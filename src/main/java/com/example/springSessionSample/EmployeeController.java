package com.example.springSessionSample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	 @Autowired
	    EmployeeService jpaExampleService;

	 
	    @PostMapping(value = "/addEmployee")
	    public ResponseEntity saveUserData(@RequestBody Employee userEntity){
	        try {
	            jpaExampleService.saveEmployeeData(userEntity);
	           return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	        }
	        catch (Exception e){
	          e.printStackTrace();
	        }
			return null;
	    }

	    @GetMapping(value = "/getEmployees")
	    public List<Employee> getUserData(){
	        try {
	            return (jpaExampleService.getEmployeeData());
	        }
	        catch (Exception e){
	        	e.printStackTrace();
	        }
			return null;
	    }
	    
	    @GetMapping(value = "/getEmployeeById/{id}")
	    public Employee updateForm(@PathVariable(value = "id") long id) {
	        Employee employee = jpaExampleService.getEmployeeById(id);
	        return employee;
	    }

	    @PutMapping(value = "/updateEmployee")
	    public ResponseEntity updateUserData(@RequestBody Employee userEntity){
	        try {
	            jpaExampleService.updateEmployeeData(userEntity);
	            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	        }
	        catch (Exception e){
	            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
	        }
	    }

	    @DeleteMapping(value = "/deleteEmployee/{id}")
	    public ResponseEntity updateUserData(@PathVariable(value = "id") Long userId){
	        try {
	            jpaExampleService.deleteEmployeeData(userId);
	            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	        }
	        catch (Exception e){
	            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
	        }
	    }
	    
	    @GetMapping("/employeesByPage")
	    public List<Employee> findAll(
	            @RequestParam(defaultValue = "0") int pageNo,
	            @RequestParam(defaultValue = "10") int pageSize,
	            @RequestParam(defaultValue = "id") String sortBy,
	            @RequestParam(defaultValue = "ASC") String sortDirection) {
	        Page<Employee> result = jpaExampleService.findAll(pageNo, pageSize, sortBy, sortDirection);
	        return result.getContent();

	    } 
	}


