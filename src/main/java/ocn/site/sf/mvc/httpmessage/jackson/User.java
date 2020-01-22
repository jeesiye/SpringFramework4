package ocn.site.sf.mvc.httpmessage.jackson;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	@Value("34")
	private int id;
	@Value("hack")
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

	@Override
	public User clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (User) super.clone();
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}