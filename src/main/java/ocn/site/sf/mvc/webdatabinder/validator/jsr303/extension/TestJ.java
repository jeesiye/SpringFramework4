package ocn.site.sf.mvc.webdatabinder.validator.jsr303.extension;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Appconf.class)
public class TestJ {

	private final Logger logger = LogManager.getLogger();
	private @Autowired WebApplicationContext wac;
	private MockMvc build;
	private @Autowired @Qualifier("paramMap") LinkedMultiValueMap<String, String> map;

	@Before
	public void init() {
		this.build = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void handlerPage() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
		ResultActions ra = build.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.view().name("register"));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void handlerRegister4success() throws Exception {
		map.add("id", "34");
		map.add("name", "hack");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register");
		requestBuilder.params(map);
		ResultActions ra = build.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.view().name("success"));
		ra.andExpect(MockMvcResultMatchers.model().attribute("message", "register success"));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void handlerRegister4Failed() throws Exception {
		map.add("id", "34");
		map.add("name", "jackson");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register");
		requestBuilder.params(map);
		ResultActions ra = build.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.view().name("register"));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

}
