package di.exam2;

import java.util.Date;
import java.util.List;

public class Order {
/*		// Customer 클래스는 Order 클래스에 대해 의존성을 갖는다. 
		// Customer 클래스의 구현 세부 사항이 변경되면 Order 클래스도 변경해줘야 하기 때문이다
	private Customer customer;
	private List<OrderItem> items;
	private Date orderDate;
	
	public Order(){
		// 생성자
		// Order 클래스는 Customer 클래스의 인스턴스 생성 방식에 의존성을 갖는다
		customer = new Customer();
	}
*/
	// TODO : 1차 의존성 해제
	// Customer 클래스가 Order 클래스에 대해 갖고 있던 의존성이 해제 되었다.
	// Customer 클래스의 구현 세부 사항을 변경해도 Order 클래스에 영향을 주는 부분이 없어진 것.
	// Customer변경 -> Order변경 보다
	// Customer변경 -> CustomerService변경 이 낫다고 판단되는 걸까?
	private CustomerService customer;
	private List<OrderItem> items;
	private Date orderDate;
	
	public Order(CustomerService customer){
		// 생성자
		// TODO : 2차 의존성 해제
		// 매개변수로 customer의 인터페이스를 매개변수로 받고,
		// Order가 생성될 때 새로운(new Customer()) 객체를 생성하는 것이 아니라
		// 필드에 넣어주는 것
		// TODO : IoCContainer 생성
		// IoCContainer는 Order를 리턴하는 getOrder() 를 갖고 있다
		//customer = new Customer();
		this.customer = customer;
	}
	
	public void saveOrder(){
		String name = customer.getName();
	}
}
