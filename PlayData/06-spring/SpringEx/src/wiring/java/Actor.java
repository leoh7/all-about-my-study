package wiring.java;



public class Actor implements Performer {
	private String name;
	private int age;
	private Role role;
	
	
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("배우 : " + name + " 은/는 " + age + " 살 입니다.");
		role.play();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
