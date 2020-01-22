package ocn.site.sf.mvc.annotation.RequestMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@ContextConfiguration(classes=Appconf.class)
public class TestJ {
	
	private final static Logger logger = LogManager.getLogger();
	private @Autowired WebApplicationContext wac;
	private MockMvc mockMvc;
	@Before
	public void prepare() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void destroy() {
		this.mockMvc = null;
	}

	@Test
	public void regex() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test/abc");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void ant() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abc.do");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void params() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
		requestBuilder.param("name", "hack").param("age", "32");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void headers() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
		requestBuilder.contentType(MediaType.TEXT_HTML_VALUE);
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void method() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/test");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

	@Test
	public void consumes() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
		requestBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("handler finished");
	}

	@Test
	public void produces() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
		requestBuilder.accept(MediaType.APPLICATION_JSON_UTF8_VALUE);// 参考doc说明，必须设置
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("handler finished");
	}

}
	
