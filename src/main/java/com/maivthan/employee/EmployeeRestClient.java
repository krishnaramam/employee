package com.maivthan.employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.maivthan.employee.model.Employee;

public class EmployeeRestClient {

	private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		EmployeeRestClient employeeRestClient = new EmployeeRestClient();
		
		// Step1: first create a new employee
		employeeRestClient.createEmployee();
		
		// Step 2: get new created employee from step1
		employeeRestClient.getEmployeeById();
		
		// Step3: get all employees
		employeeRestClient.getEmployees();
		
		// Step4: Update employee with id = 1
		employeeRestClient.updateEmployee();
		
		// Step5: Delete employee with id = 1
		employeeRestClient.deleteEmployee();
	}

	private void getEmployees() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
				String.class);

		System.out.println(result);
	}

	private void getEmployeeById() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, Employee.class, params);

		System.out.println(result);
	}

	private void createEmployee() {

		Employee newEmployee = new Employee("admin", "admin", "admin@gmail.com");

		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newEmployee, Employee.class);

		System.out.println(result);
	}

	private void updateEmployee() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		Employee updatedEmployee = new Employee("admin123", "admin123", "admin123@gmail.com");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, updatedEmployee, params);
	}

	private void deleteEmployee() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL, params);
	}
}
