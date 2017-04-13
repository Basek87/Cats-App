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
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.dawidbasa.cats.controllers.AdminController;
import pl.dawidbasa.cats.model.Cat;
import pl.dawidbasa.cats.services.CatService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/lib/dispatcher-servlet.xml",
		"file:src/test/java/pl/dawidbasa/cats/test/config/dataSource.xml",
		"file:src/test/java/pl/dawidbasa/cats/test/config/test-context.xml" })
public class AdminControllerTests {

	private static final int TEST_CAT_ID_1 = 1;
	private static final int TEST_CAT_ID_2 = 2;
	private MockMvc mockMvc;
	private Cat testCat1;
	private Cat testCat2;
	
	@Autowired
	private CatService catServiceMock;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	DataSource dataSource;
	@InjectMocks
	AdminController adminController;

	@Before
	public void initSetup() {
		Mockito.reset(catServiceMock);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from cats");
		
		testCat1 = new Cat();
		testCat1.setId(TEST_CAT_ID_1);
		testCat1.setName("Wacek");
		testCat1.setOwnerName("Dawid");
		testCat1.setAge(5);
		
		testCat2 = new Cat();
		testCat2.setId(TEST_CAT_ID_2);
		testCat2.setName("Boniek");
		testCat2.setOwnerName("Roman");
		testCat2.setAge(2);
	}

	@Test
	public void TestAdminPage() throws Exception {
		// Get Request with url "/" and expect name of view "cat"
		mockMvc.perform(get("/admin"))
			.andExpect(status().isOk())
			.andExpect(view().name("admin"))
			.andExpect(model().size(1));
	}

	@Test
	public void TestDbManagmentPage() throws Exception {
		// Get Request with url "/" and expect name of view "cat"
		mockMvc.perform(get("/admin/dbManagment"))
			.andExpect(status().isOk())
			.andExpect(view().name("dbManagment"))
			.andExpect(model().size(2));
	}

	@Test
	public void testAddCat() throws Exception {
		mockMvc.perform(post("/admin/dbManagment/addCat")
			.param("name", "Wacek")
			.param("ownerName", "Dawid")
			.param("age", "5"))
				
			.andExpect(model().attribute("cat", hasProperty("name", is("Wacek"))))
			.andExpect(model().attribute("cat", hasProperty("ownerName", is("Dawid"))))
			.andExpect(model().attribute("cat", hasProperty("age", is(5))))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().attributeExists("cat"));
	}

	
	
}
