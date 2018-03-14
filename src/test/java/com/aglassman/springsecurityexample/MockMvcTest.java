package com.aglassman.springsecurityexample;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.aglassman.springsecurityexample.security.CustomUser;

import static com.aglassman.springsecurityexample.security.CustomAuthorities.*;
import static org.springframework.restdocs.http.HttpDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MockMvcTest {
	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("build/generated-snippets/");

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() {
		MockMvcRestDocumentationConfigurer docs = documentationConfiguration(this.restDocumentation);

		docs.snippets()
			.withDefaults(
				httpRequest(),
				httpResponse());

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
			.apply(SecurityMockMvcConfigurers.springSecurity())
			.apply(docs)
			.alwaysDo(
				document("{method-name}/{step}",
					preprocessRequest(prettyPrint()),
					preprocessResponse(prettyPrint())))
			.build();
	}

	@Test
	public void testGetAllItems() throws Exception {

		this.mockMvc.perform(get("/items")
				.with(user("vendor").password("pw").authorities(VENDOR)))
			.andExpect(status().isOk());
	}

	@Test
	public void testGetOneItem_nonPreferred() throws Exception {

		this.mockMvc.perform(get("/items/1")
			.with(user("vendor").password("pw").authorities(VENDOR)))
			.andExpect(status().isOk())
			.andDo(document("item-links",
				links(
					linkWithRel("self").ignored(),
					linkWithRel("item").ignored(),
					linkWithRel("stockList").description("Link the current stock list for this item."))));
	}

	@Test
	public void testGetOneItem_preferredItem_notPreferredVendor() throws Exception {

		this.mockMvc.perform(get("/items/6")
			.with(user("vendor").password("pw").authorities(VENDOR)))
			.andExpect(status().isForbidden());
	}

	@Test
	public void testGetOneItem_preferredItem_preferredVendor() throws Exception {

		this.mockMvc.perform(get("/items/6")
			.with(user("vendor_preferred").password("pw").authorities(PREFERRED_VENDOR,VENDOR)))
			.andExpect(status().isOk());
	}

	@Test
	public void testGetItemSearch() throws Exception {

		this.mockMvc.perform(get("/items/search")
			.with(user("admin").password("pw").authorities(EMPLOYEE)))
			.andExpect(status().isOk());
	}

	@Test
	public void testGetInventoryReport() throws Exception {

		CustomUser customUser = new CustomUser();
		customUser.setCanReport(true);
		customUser.setUsername("admin");
		customUser.setPassword("pw");
		customUser.setEmployee(true);
		customUser.setId(1l);
		customUser.setPreferred(false);

		this.mockMvc.perform(get("/inventory/report")
				.param("itemId","1")
				.with(user(customUser)))
			.andExpect(status().isOk());
	}
}
