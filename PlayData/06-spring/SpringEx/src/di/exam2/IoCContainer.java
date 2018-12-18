package di.exam2;
import di.exam.Order;

public class IoCContainer {
	public Order getOrder(){
		// TODO : IoCcontainer
		// Customer의 인스턴스를 여기서 생성해서
		// 그 참조정보를 담은 Order를 리턴하는 것
		CustomerService customer = new Customer();
		return new Order(customer);
	}
}
