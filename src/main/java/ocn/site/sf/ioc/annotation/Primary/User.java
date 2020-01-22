package ocn.site.sf.ioc.annotation.Primary;

public class User {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}

}
