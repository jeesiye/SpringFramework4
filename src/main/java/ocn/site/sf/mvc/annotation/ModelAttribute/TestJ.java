package ocn.site.sf.mvc.annotation.ModelAttribute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Appconf.class)
public class TestJ {

	private final static Logger logger = LogManager.getLogger();
	private @Autowired WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void initialized() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void destroy() {
		this.mockMvc = null;
	}

	@Test
	public void testOnMethod0() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test0");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void testOnMethod1() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test1");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void testOnMethod2() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test2");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

}
