package ocn.site.sf.ioc.annotation.Qualifier;

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
