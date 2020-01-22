package ocn.site.sf.ioc.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

	@Bean
	public Person getPerson() {
		// TODO Auto generated method stub
		return new Person();
	}

	@Bean
	public User getUser() {
		// TODO Auto generated method stub
		return new User();
	}

}
