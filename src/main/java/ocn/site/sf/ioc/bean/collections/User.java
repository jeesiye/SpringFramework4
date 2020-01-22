package ocn.site.sf.ioc.bean.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {

	private List<Integer> list;
	private Set<Integer> set;
	private Map<Integer, String> map;
	private Integer[] array;
	private Properties props;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Set<Integer> getSet() {
		return set;
	}

	public void setSet(Set<Integer> set) {
		this.set = set;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public Integer[] getArray() {
		return array;
	}

	public void setArray(Integer[] array) {
		this.array = array;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "User [list=" + list + ", set=" + set + ", map=" + map + ", array=" + Arrays.toString(array) + ", props="
				+ props + "]";
	}

	public User(List<Integer> list, Set<Integer> set, Map<Integer, String> map, Integer[] array, Properties props) {
		super();
		this.list = list;
		this.set = set;
		this.map = map;
		this.array = array;
		this.props = props;
	}

	public User() {
		super();
	}

}
