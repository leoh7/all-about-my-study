/*

추상 메서드를 하나라도 가지면 추상 클래스가 된다.
추상 메서드는 구현하지 않는다.
추상 클래스임을 명시해야 한다.

객체를 생성할 수 없다. 항상 상속으로 구현된다.
상속 시 추상 메서드는 구현해야 한다.
일반 변수 메서드 상수를 가질 수 있다.


*/

abstract class  AbstractSuper	{		//추상클래스	명시해야 한다.
	int a = 10;
//	public int getA()		// 선언부만 존재 하는 것.
//	public int getA(){	return a; }	// 선언부와 구현부가 다 되어있는것
//	public abstract int getA(){	return a; }			
				// AbstractSuper.java:18: error: abstract methods cannot have a body	/ 구현하지 말라는 에러

	public abstract int getA();			//추상메서드	구현하지 않는다.
				// AbstractSuper.java:12: error: AbstractSuper is not abstract and does not override abstract method getA() in AbstractSuper	/	외우세요 이 에러 메세지
												// AbstractSuper 라는 클래스는 추상매서드가 아니다 / 혹은 getA()라는 메서드는 AbstractSuper에 오버라이드(상속 시에만 쓴다 오버라이드) 되어있지 않다. 
				// 추상메서드는 완료 됐는데 클래스도 추상 클래스로 만들어 줘야되
}

class AbstractEx extends AbstractSuper {
	public int getA(){	return a;	}	// override 재정의 함
	
	
	public static void main (String [] args){
//	AbstractSuper as = new AbstractSuper();		// AbstractSuper.java:30: error: AbstractSuper is abstract; cannot be instantiated	/	new 에서 에러가 뜸
																		// 추상클래스는 인스턴스화 될 수 없다. / 정확하게는 객체를 생성할 수 없다 까지는 안되고 참조변수를 가질 순 있어.

	/*왜 newㄹ르 할 수 없는가 / new 라는건 힙 영역에 메모리 할당 해달라는 주문 / 추상메서드, 추상클래스 / 실제로는 선언부 밖에 없다. 실제로 뭐를 해라 라는 구현부가 없는 메서드는 미완성의 상태(할 일이 없다) / 메모리 할당을 받으려고 봤더니 클래스가 미완성이기 때문에 힙 영역에 메모리 할당이 안되는 것. / 미완성 된 부분을 완성해주면 new가 됨 / 내부 클래스 / 내부 클래스.익명 내부클래스
	일단 지금은 그렇게만 알아둘 것. 추상클래스만 가지고는 객체 생성이 안 된다. 
	AbstarctSuper as;	// 이건 됨. 참조변수를 못 갖는건 아냐. 
	*/
	
		AbstractEx ae = new AbstractEx();
		System.out.println("a :" + ae.getA() );

	
	}
}

/*
	추상메서드라는 것이 이 복잡한 일들의 원흉. 저 추상메서드가 들어오면서
	추상클래스가 될 수 밖에 없고, 추상클래스니까 객체 생성을 못하고
	못하니까 상속을 받고, 상속을 받다 보니까 재정의 해야되

	돌아오긴 했는데 결과적으로 자식클래스 쪽에 재정의가 들어갈 수 밖에 없어(override)
	추상메서드는 자식클래스에게 무조건 재정의 할 수 밖에 없게 만드는 것.
			틀을 정한다. 제약을 준다.
		ex)	자동차( 최소한의 제약, 틀)	/	기본 조건이 충족 되었는가? / y->상속 가능, n->상속 불가능 
		트럭, 버스, 승용차, 오토바이	/	자전거
		
	C에서도 다형성을 구현하기도 하지만 의미가 없음
	자바는 재정의 되어 있는 애들은 다형성이 구현되었다고 그냥 보면 됨. 그 대표적 예가 toString /  
*/
	
