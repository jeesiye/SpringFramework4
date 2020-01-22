package ocn.site.sf.mvc.httpmessage.fastjson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.alibaba.fastjson.JSONObject;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/mvc/httpmessage/fastjson/appconf.xml")
public class TestX {

	private final static Logger log = LogManager.getLogger();
	private @Autowired WebApplicationContext wac;
	private @Autowired User user;

	@Test
	public void run() throws Exception {

		MockMvc build = MockMvcBuilders.webAppContextSetup(this.wac).build();

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/test");
		String jsonString = JSONObject.toJSONString(user);
		requestBuilder.content(jsonString);
		requestBuilder.contentType(MediaType.APPLICATION_JSON_UTF8);
		log.info("start request");

		ResultActions ra = build.perform(requestBuilder);

		user.setName("rose");
		ra.andExpect(MockMvcResultMatchers.content().json(JSONObject.toJSONString(user)));
		ra.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		log.info("end response");

	}

}
