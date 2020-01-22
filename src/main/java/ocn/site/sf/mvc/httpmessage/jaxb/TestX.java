package ocn.site.sf.mvc.httpmessage.jaxb;

import java.io.File;
import java.io.InputStream;

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

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/mvc/httpmessage/jaxb/appconf.xml")
public class TestX {

	private final static Logger log = LogManager.getLogger();
	private @Autowired WebApplicationContext wac;

	@Test
	public void run() throws Exception {

		MockMvc build = MockMvcBuilders.webAppContextSetup(this.wac).build();

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/test");
		Class<? extends TestX> cls = this.getClass();
		String path = cls.getPackage().getName().replaceAll("\\.", "/").concat(File.separator + "data.xml");
		log.info("loading xml path is {}", path);
		InputStream is = cls.getClassLoader().getResourceAsStream(path);
		log.info("get inputstream instance is {}", is);
		byte[] bytes = new byte[is.available()];
		is.read(bytes);
		is.close();
		String xmlData = new String(bytes);
		log.info("loading xml content is : {}", xmlData);
		requestBuilder.content(xmlData);
		requestBuilder.contentType(MediaType.APPLICATION_XML);

		ResultActions ra = build.perform(requestBuilder);
		log.info("start request");

		ra.andExpect(MockMvcResultMatchers.content().xml(xmlData));
		ra.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_XML));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		log.info("end response");

	}

}
