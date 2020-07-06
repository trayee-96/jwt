package com.cognizant.springlearn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Assert;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest(classes=SpringLearnApplication.class)
@AutoConfigureMockMvc 
class SpringLearnApplicationTests {

	@Autowired
	private CountryController countryController;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void contextLoads() {
		Assert.notNull(countryController,"Country object not null"); 
	}
	 @Test 
	public void testGetCountry() throws Exception { 
		 ResultActions actions = mockMvc.perform(get("/country")); 
		 actions.andExpect(status().isOk()); 
		 actions.andExpect(jsonPath("$.code").exists()); 
		 actions.andExpect(jsonPath("$.code").value("IN")); 
		 actions.andExpect(jsonPath("$.name").exists()); 
		 actions.andExpect(jsonPath("$.name").value("India")); 
	    } 

	 @Test
	public void testGetCountryException() throws Exception {
		 ResultActions actions = mockMvc.perform(get("/countries/a"));
		actions.andExpect(status().isNotFound()); 
		actions.andExpect(status().reason("Countrynotfound")); 

	}

}
