package hpe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	@Mock
	private EmployeeManager employeeManager;

	@InjectMocks
	private EmployeeController employeeController;

	@Test
	void getEmployeesReturnsListFromManager() {
		Employees employees = new Employees();
		employees.getEmployeeList().add(new Employee("1", "First", "Last", "Email", "Title"));

		when(employeeManager.getAllEmployees()).thenReturn(employees);

		List<Employee> result = employeeController.getEmployees();

		assertEquals(1, result.size());
		assertEquals(employees.getEmployeeList(), result);
	}

	@Test
	void addEmployeeCreatesLocationHeader() {
		Employee employee = new Employee("99", "First", "Last", "Email", "Title");
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/employees");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		try {
			ResponseEntity<Void> response = employeeController.addEmployee(employee);

			verify(employeeManager).addEmployee(employee);
			assertEquals(201, response.getStatusCode().value());
			URI location = response.getHeaders().getLocation();
			assertNotNull(location);
			assertTrue(location.toString().endsWith("/employees/99"));
		} finally {
			RequestContextHolder.resetRequestAttributes();
		}
	}
}