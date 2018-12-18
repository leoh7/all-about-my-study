package wiring.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanWiringTest {
	public static void main(String[] args) throws PerformanceException {
		
		//// 강한 결합
		// 객체를 생성하는데 참조변수도 쓰려는 클래스 꺼, 인스턴스도 쓰려는 클래스 꺼.
//		Juggler hong = new Juggler();
//		hong.perform();
		
		//// 느슨한 결합
		// 참조변수는 부모로 만듬, 그다음에 정글러를 넣어
//		Performer kim = new Juggler();	// 실제로는 Performer 형으로 자동형변환 되어 들어감 // 부모는 자식을 받아주니까
//		kim.perform();	// 부모를 실행했는데 자식이 실행이 되는 것
			// 근데 이러면 소스파일을 수정하지 않으면 갈아낄 수가 없네?
			// 그래서 나오는게 DI
			// 필요한 객체를 주입을 시켜버리고, 자바입장에서는 주입된 객체를 받아서 사용하는 것.
			// 자바입장에서는 종속적으로 객체를 주입 받아서 쓴다. 하는 것.
		
		//// DI Dependency Injection
		// 객체는 ApplicationContext.xml 에다가 만든다 -> 관리는 컨테이너가
		// xsi:schemaLocation 에 있는 주소들을 들어가 보면 더 상세히 볼 수 있다.
		ClassPathXmlApplicationContext ctx 
			= new ClassPathXmlApplicationContext("wiring/bean/ApplicationContext.xml");
		// factory method
		Stage stage = (Stage) ctx.getBean("stage");
		stage.message();
		
		// Juggler
		Performer lee = (Performer) ctx.getBean("lee");
		lee.perform();
		
/*		//// Singleton / prototype
			// 객체를 bean 이라고 만들어 놓으면 컨테이너가 객체를 만들어서 갖고 있는다.
			// getBean 하면 그 객체를 내놔라, 하는 것.
			// 이걸 두번 가져와 볼 것임
		Ticket t1 = (Ticket) ctx.getBean("ticket");
		Ticket t2 = (Ticket) ctx.getBean("ticket");
		t1.reservation();	// 티켓번호 : 1
		t2.reservation();	// 티켓번호 : 2
			// 두개가 같은 객체라는 뜻이다
		System.out.println("t1 : " + t1 + "\n" + "t2 : " + t2); 
			// 객체를 달라고 할 때마다 다시 만들면 낭비가 생긴다
			// 기본적으로 Spring 은 기본 값이 싱글톤 패턴으로, 인스턴스를 컨테이너당 하나씩만 만들어서 쓰는 것.
			// 따로 만들고 싶을땐? scope="prototype" 으로 설정해준다
		
*/		
		
		
		
		System.out.println();
		// 연습용 Singer
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
		
	}
}








