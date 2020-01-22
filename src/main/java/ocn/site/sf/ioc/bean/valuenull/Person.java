package ocn.site.sf.ioc.bean.valuenull;

import java.util.List;

public class Person {

	private List<Object> list;

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Person [list=" + list + "]";
	}

}
