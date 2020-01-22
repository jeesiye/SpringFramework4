package ocn.site.sf.mvc.tag.form;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
	}

}