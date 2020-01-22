package ocn.site.sf.mvc.webdatabinder.validator.jsr303.extension;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	@FieldSize(size = 5)
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