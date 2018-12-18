package di.exam;

import java.util.Date;
import java.util.List;

public class Order {
		// Customer 클래스는 Order 클래스에 대해 의존성을 갖는다. 
		// Customer 클래스의 구현 세부 사항이 변경되면 Order 클래스도 변경해줘야 하기 때문이다
	private Customer customer;
	private List<OrderItem> items;
	private Date orderDate;
	
	public Order(){
		// Order 클래스는 Customer 클래스의 인스턴스 생성 방식에 의존성을 갖는다
		customer = new Customer();
	}
	
	public void saveOrder(){
		String name = customer.getName();
	}
}
