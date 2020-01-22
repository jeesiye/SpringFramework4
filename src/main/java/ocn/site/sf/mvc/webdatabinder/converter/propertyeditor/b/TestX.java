package ocn.site.sf.mvc.webdatabinder.converter.propertyeditor.b;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@ContextConfiguration("classpath:ocn/site/sf/mvc/webdatabinder/converter/propertyeditor/b/appconf.xml")
public class TestX {

	private final Logger logger = LogManager.getLogger();
	private @Autowired WebApplicationContext wac;

	@Test
	public void run() throws Exception {
		MockMvc build = MockMvcBuilders.webAppContextSetup(this.wac).build();
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
		requestBuilder.param("param", "2019-04-26");
		ResultActions ra = build.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		logger.info("test finished");
	}

}
