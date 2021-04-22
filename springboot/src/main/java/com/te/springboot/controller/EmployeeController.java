package com.te.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.EmployeeBean;
import com.te.springboot.bean.EmployeeResponse;
import com.te.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(path = "/getEmp", produces = 
		{MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getEmployee(int id) {
		EmployeeResponse response = new EmployeeResponse();
	EmployeeBean bean = service.searchemp(id);
	if(bean != null) {
		response.setStatusCode(200);
		response.setMsg("Success");
		response.setDescription("Employee data found for id :"+id);
		response.setBean(bean);
	} else {
		response.setStatusCode(404);
		response.setMsg("Failure");
		response.setDescription("Employee data not found for id :"+id);
	}
	return response;
	}//end of getEmployee
	
	@GetMapping(path = "/getAll", produces = 
		{MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getEmpAll() {
		EmployeeResponse response = new EmployeeResponse();
		java.util.List<EmployeeBean> bean  = service.getAllData(); 
		if(bean != null) {
			response.setStatusCode(100);
			response.setMsg("Success");
			response.setDescription("All the details are displayed");
			response.setEmployeeBeans(bean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure");
			response.setDescription("Something went wrong");
		}
		return response;
	}
	
	@DeleteMapping(path = "/delete/{emp_id}", produces = 
		{MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse deleteEmp(@PathVariable(name = "emp_id") int id) {
		EmployeeResponse response = new EmployeeResponse();
	   if(service.deleteEmp(id)) {
		   response.setStatusCode(100);
		   response.setMsg("Success");
		   response.setDescription("Data deleted for id :"+id);
	   } else {
		   response.setStatusCode(404);
		   response.setMsg("Failure");
		   response.setDescription("Data not for id :"+id);
	   }
	   return response;
	}

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmp(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.addemp(employeeBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//
	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmp(@RequestBody EmployeeBean bean) {
		System.out.println(bean);
		EmployeeResponse response = new EmployeeResponse();
		if (service.update(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}
}
