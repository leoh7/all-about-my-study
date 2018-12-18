/*
확실한 제약을 줘야되다 보니까 기존의 클래스와 구분을 해야 할 필요가 생김
제약에 좀 가해져 있는 클래스 
인터페이스는 명세서다, 메뉴판이다.
	인터페이스는 계획표다
	계획을 짠다는 것은 이상적인 것.
	실제로 못하는 것이 많다. 복잡해서든 하드웨어적인 문제(자바가 건드릴 수 없는)이든.
	일단 계획이 미리 짜여져 있다고 생각하면 된다.

인터페이스 interface
interface 키워드를 사용한다
	상수와 추상 메소드로만으로 구성된다	//	final, abstract
final, abstract 키워드를 따로 들이지 않는다.
interface는 객체를 생성할 수 없다
상속 시 implements(구현) 키워드를 사용한다.
상속 시 추상 메소드는 '빠짐없이' 구현해야 한다.	/ 이게 단점이 되	/ 다중 상속 까지 하면... 엄청 구현해야되	/ 해결하는 방법이 있어	/ adapter 클래스
다중 상속이 가능하다.

*/
interface Inter1 {	
//	int a;	//InterEx1.java:15: error: = expected	/ final(생략되어있음)	초기화 해야한다.	/	상수화되었기 때문에 왠만하면 static 써주라했지	/	static도 생략되어있음
													// static final 초기화해야한다	
	int a = 10;
//	public int getA(){ return a;}	// InterEx1.java:17: error: interface abstract methods cannot have body	/ 인터페이스 추상 메서드는 구현부를 가질 수 없다.	 
									//abstract	구현할 수 없다.
	public int getA();

}	

class InterEx1 implements Inter1 {	// extends 확장	// interface 그냥 진짜 껍데기
	public int getA(){ return a; }

	public static void main(String[] args) 	{
//		Inter1.a = 20;	//InterEx1.java:21: error: cannot assign a value to final variable a	/ 허	/ final 이 적용되어 있다는 소리
		System.out.println("static임을 증명하는 a : "+Inter1.a);	// 이게 구현된다는 것은 static이 적용되어 있다는 소리
//		Inter1 in = new Inter1();				// InterEx1.java:27: error: Inter1 is abstract; cannot be instantiated
//		Inter1 in;	// 이건 됩니다. new가 안되는 것	// 익명 내부클래스를 쓰면 new 됩니다.
		InterEx1 ie = new InterEx1();
		System.out.println("implements 한 클래스를(InterEx1) 구현하고 인스턴스화 한 다음 메서드 getA() : "+ie.getA());

	}
}
