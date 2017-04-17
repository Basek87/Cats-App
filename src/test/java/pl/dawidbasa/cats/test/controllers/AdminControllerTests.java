package pl.dawidbasa.cats.test.controllers;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.dawidbasa.cats.services.CatService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/lib/dispatcher-servlet.xml",
		"file:src/test/java/pl/dawidbasa/cats/test/config/dataSource.xml",
		"file:src/test/java/pl/dawidbasa/cats/test/config/test-context.xml" })
public class AdminControllerTests {
	private MockMvc mockMvc;
	
	
	@Autowired
	private CatService catServiceMock;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	DataSource dataSource;
	
	@Before
	public void initSetup() {
		Mockito.reset(catServiceMock);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void TestShowAdminPage() throws Exception {
		mockMvc.perform(get("/admin"))
			.andExpect(status().isOk())
			.andExpect(view().name("admin"))
			.andExpect(model().size(1));
	}

	@Test
	public void TestShowDbManagmentPage() throws Exception {
		mockMvc.perform(get("/admin/dbManagment"))
			.andExpect(status().isOk())
			.andExpect(view().name("dbManagment"))
			.andExpect(model().size(2));
	}

	@Test
	public void testAddCat() throws Exception {
		mockMvc.perform(post("/admin/dbManagment/addCat")
			.param("name", "Klakier")
			.param("ownerName", "Dawid")
			.param("age", "5"))
			.andExpect(model().attribute("cat", hasProperty("name", is("Wacek"))))
			.andExpect(model().attribute("cat", hasProperty("ownerName", is("Dawid"))))
			.andExpect(model().attribute("cat", hasProperty("age", is(5))))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().attributeExists("cat"));
	}

	
	
}
