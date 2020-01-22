package ocn.site.sf.mvc.webdatabinder.validator.i18n;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {

	// spring将数据校验的错误信息绑定在 FieldError 对象中 而此对象是 MessageSourceResolvable 的实现类
	// 在springmvc的国际化框架中 MessageSourceResolvable 又是解析国际化信息的对象
	// 故 可以在数据校验的时候 同时绑定国际化版本的错误信息提示
	// 结合JSR303的使用效果更加 在国际化属性文件中key的值就是 注解名称.标记字段的类名.标记的字段名称
	// 如 Length.user.name

	// 在页面上显示错误信息的时候 测试的环境中 spring的message标签和form的error标签 同时支持显示国际化的信息显示
	private static final long serialVersionUID = 1L;
	private int id;
	@Length(min = 4)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}