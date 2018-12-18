package test.di;

public class Base implements Partition {
	private String name;
	private String role;
	@Override
	public void live() throws PerformanceException {
		// TODO Partition - Base
		System.out.println(role + " : " + name);

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
