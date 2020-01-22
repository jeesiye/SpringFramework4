package ocn.site.sf.ioc.annotation.Primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Appconfig {

	@Bean
	public User getUser1() {
		// TODO Auto generated method stub
		return new User();
	}

//	当容器中存在两个或两个以上的同类型的bean时,
//	使用 @Primary 注解,表示在默认的自动装配时,
//	此注解标记的bean,其优先级最高,首选被依赖注入
	@Bean
	@Primary
	public User getUser2() {
		// TODO Auto generated method stub
		User user = new User();
		user.setId(34);
		return user;
	}

}
