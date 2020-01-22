package ocn.site.sf.ioc.annotation.DependsOn;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + "]";
	}

}
