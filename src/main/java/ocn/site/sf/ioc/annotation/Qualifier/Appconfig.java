package ocn.site.sf.ioc.annotation.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ocn.site.sf.ioc.annotation.Qualifier")
public class Appconfig {

	@Bean("aperson")
	public Person getPerson1() {
		// TODO Auto generated method stub
		return new Person();
	}

	@Bean("person")
	public Person getPerson2() {
		// TODO Auto generated method stub
		Person obj = new Person();
		obj.setId(34);
		return obj;
	}

}
