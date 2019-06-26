package org.com.data.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.com.data.interceptor.AdminInterceptor;
import org.com.data.repository.AdminRepository;
import org.com.data.services.AdminServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminTestController {

	@MockBean
	private AdminServices adminservices;

	@MockBean
	private AdminInterceptor adimInterceptor;

	@MockBean
	private AdminRepository adminrepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void message() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/message")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().string("Welcome Admin")).andReturn();
	}
}
