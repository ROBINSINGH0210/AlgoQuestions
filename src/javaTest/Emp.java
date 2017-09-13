package javaTest;

public class Emp {

	private Integer id;
	private String name;

	public Emp(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

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

	/*
	 * @Override public int hashCode() { return 1; }
	 */
	/*
	 * @Override public boolean equals(Object obj) { // TODO Auto-generated
	 * method stub return true; }
	 */
}
