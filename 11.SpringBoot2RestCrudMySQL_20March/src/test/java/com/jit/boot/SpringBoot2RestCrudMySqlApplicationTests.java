package com.jit.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@TestPropertySource("classpath:application-test.properties")
@AutoConfigureMockMvc
public class SpringBoot2RestCrudMySqlApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("EMPLOYEE SAVE")
	@Order(1)
	@Disabled
	public void testSaveEmployee() throws Exception {
		// 1. request object
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/rest/employee/save")
				.contentType("application/json")
				.content("{\"empName\":\"ABCDEFGH\",\"empMail\":\"abcd@gmail.com\",\"empSal\":20000.0}");

		// 2. execute and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. read response
		MockHttpServletResponse response = result.getResponse();

		// 4. validate(assert) response details
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		if (!response.getContentAsString().contains("Employee saved")) {
			fail("Employee not created");
		}
	}

	@Test
	@DisplayName("FETCH ONE EMPLOYEE")
	@Order(2)
	@Disabled
	public void testGetOneEmployee() throws Exception {
		// 1. request creation
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/rest/employee/find/1");

		// 2. execute and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3.read response
		MockHttpServletResponse response = result.getResponse();

		// 4. Validate data
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}

	@Test
	@DisplayName("FETCH ONE EMPLOYEE NOT FOUND")
	@Order(3)
	@Disabled
	public void testGetOneEmployeeNotExist() throws Exception {
		// 1.request creation
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/rest/employee/find/10");

		// 2.execute and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3.read response
		MockHttpServletResponse response = result.getResponse();

		// 4.validate data
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if (!response.getContentAsString().contains("Not exist")) {
			fail("Employee Exist ! Check it once !!");
		}
	}

	@Test
	@DisplayName("FETCH ALL EMPLOYEES")
	@Order(4)
	@Disabled
	public void testAllEmployees() throws Exception {
		// 1. request creation
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/rest/employee/all");

		// 2. execute and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. read response
		MockHttpServletResponse response = result.getResponse();

		// 4. validate data
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		System.out.println(response.getContentAsString());
	}

	@Test
	@DisplayName("REMOVE ONE EMPLOYEE BY ID")
	@Order(5)
	@Disabled
	public void testRemoveOneEmployee() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/employee/remove/10");
		// 2. execute and get result
		MvcResult result = mockMvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if (!response.getContentAsString().contains("Employee deleted")) {
			fail("Unable to Delete");
		}
	}
	
	@Test
	@DisplayName("UPDATE ONE EMPLOYEE BY ID")
	@Order(6)
	@Disabled
	public void testUpdateOneEmployee() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/rest/employee/update")
				.contentType("application/json")
				.content("{\"empId\":1,\"empName\":\"jitendra\",\"empMail\":\"jk@gmail.com\",\"empSal\":20000.0}");;
		// 2. execute and get result
		MvcResult result = mockMvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if (!response.getContentAsString().contains("Employee updated")) {
			fail("Unable to update");
		}
	}
	
	@Test
	@DisplayName("UPDATE ONE EMPLOYEE EMIAL ID")
	@Order(7)
	public void testUpdateOneEmployeeEmail() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/rest/employee/modify/1/rk93.161@gmail.com");
		// 2. execute and get result
		MvcResult result = mockMvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if (!response.getContentAsString().contains("Email Updated")) {
			fail("Unable to update mail");
		}
	}

}
