package bean;

public class SimpleBean {
	private String name;
	private int age;
	private String tel;
	private String address;
	
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

// 바구니에 넣는 이유는 편의 처리, 바구니랑 DB랑 똑같이 할 필요는 없지만 같은 데이터라는 의미로 자료형, 이름을 다 맞춰 준다.
// 더 중요한 건, 입력받는 form 에 있는 이름들과, 바구니에 있는 이름과 맞춰줘야 해.
// 그래야 useBean 액션태그를 사용할 수 있어.

