package ocn.site.sf.ioc.bean.dependson;

public class PersonInit {

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "PersonInit [person=" + person + "]";
	}

}
