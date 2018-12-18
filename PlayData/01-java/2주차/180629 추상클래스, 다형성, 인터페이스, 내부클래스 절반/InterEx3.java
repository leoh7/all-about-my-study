/*
클래스 사용하는법 5가지
인터페이스 사용하는법 5가지
1.내가 직접 implements 해서 구현해 쓰는 방법					//Interface WindowListener 얘를 갖고 오면 메서드가 7개 이걸 다 구현해야 된다는 얘기
2.아답터 클래스(대신 구현할 클래스)를 구현하는 것. 어려운 인터페이스 클래스일 수록, 대신 구현해 놓은 클래스가 존재 한다. window adpater, mouse adapter 등등
*/
// Adapter Class
interface Inter3 extends Inter1, Inter2{
	int c = 30;
	public int getC();
}
/*
abstract class InterSuper implements Inter3 {		// InterSuper 라는 클래스는 추상매서드가 아니다 / 혹은 getA()라는 메서드는 InterSuper에 오버라이드(상속 시에만 쓴다 오버라이드) 되어있지 않다. 
//abstract class InterSuper implements Inter3 {		// 자식에게 구현 의무를 떠넘긴 경우	// 자신이 추상클래스가 되버렸다
	public int getA(){ return a; }		// 반대로 부모가 구현을 하고 자식한테 의무가 없어지는 경우
	public int getB(){ return b; }
	public int getC(){ return c; }											

}
객체화가 되네?
추상 메서드도 없는데 추상클래스를 쓰네?

이렇게 하면 좋은게 뭐냐 자식이 구현의무가 사라져(InterEx3)
가져올 인터페이스에 10개 메서드가 있는데 그 중에 1개만 가져오고 싶어
내가 쓰고 싶지 않은 메서드까지 구현해야 된다는 것. 빠짐없이
	이렇게 중간에 InterSuper가 끼어들어서 다 구현해놓으니깐
	자식인 InterEx3(실제로 사용하는 클래스)가 구현할 의무가 없어지는 것.

실제로 가져다 사용하라고 구현해 놓은 클래스도 많지만
아답터라고 되있는 클래스 들은 진짜 대신 저 구현만 해놨지 안에 내용이 아무것도 없어
그런 아답터 클래스를 객체로 만들어서 메서드를 호출해봤자 의미가 없네?
이런 클래스들은 객체를 생성해서 사용하면 안되. 의미가 없다.
	그래서 정말로
	정말로 의미없이 구현만 해놓은 클래스들은 abstract 를 박아놔 클래스에
	이런애들은 상속해서 재정의(오버라이드)를 해서 갖다 써야 되.

진짜로 어려워서 구현해놓은 클래스(진짜 복잡하고 어려운애들)은 
abstract가 없다.
*/

abstract class InterSuper implements Inter3 {		
	public int getA(){ return a; }		
	public int getB(){ return b; }
	public int getC(){ return c; }											

}


class InterEx3 extends InterSuper {
	

	public static void main(String[] args) {
		InterEx3 ie = new InterEx3();		

		System.out.println("interface Inter3가 상속받은 Inter1 의 a: "+ ie.getA());
		System.out.println("interface Inter3가 상속받은 Inter2 의 b: "+ ie.getB());
		System.out.println("interface Inter3를 구현한(implements) c: "+ ie.getC());
	}
}
