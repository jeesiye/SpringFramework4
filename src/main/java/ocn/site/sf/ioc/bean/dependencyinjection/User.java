package ocn.site.sf.ioc.bean.dependencyinjection;

public class User {

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "User [person=" + person + "]";
	}

	public User(Person person) {
		super();
		this.person = person;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
