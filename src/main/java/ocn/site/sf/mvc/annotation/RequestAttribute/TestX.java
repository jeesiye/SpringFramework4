package ocn.site.sf.mvc.annotation.RequestAttribute;

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
@ContextConfiguration("classpath:ocn/site/sf/mvc/annotation/RequestAttribute/appconf.xml")
public class TestX {


	private final static Logger log = LogManager.getLogger();
	private @Autowired WebApplicationContext wac;

	@Test
	public void run() throws Exception {
		MockMvc build = MockMvcBuilders.webAppContextSetup(this.wac).build();
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
		requestBuilder.requestAttr("attr", "hack");
		ResultActions ra = build.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		log.info("end response");
	}
	
}
