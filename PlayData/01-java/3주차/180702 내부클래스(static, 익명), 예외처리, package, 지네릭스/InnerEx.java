/*
내부클래스	Inner Class

	
	Member		내부 클래스의 멤버 변수나 멤버 메서드들과 같이(같은 위치에) 클래스가 정의
				외부 클래스의 멤버를 참조할 수 있다.
				static 변수를 가질 수 없다.						// 알고는 계세요
				객체를 생성하기 위해서는 외부 클래스의 객체를 먼저 생성해야 한다.

	Local		특정한 메서드 내에 클래스가 정의된 경우	// 활용도가 적어서 거의 안 씀
				간단한 기능을 갖는 임시 클래스로 사용
				메소드 내부에서 선언되고 메서드 안에서만 객체화 할 수 있다.
				메서드 외부에서는 사용할 수 없습니다.
				접근수정자(modifier)를 사용할 수 없다.

	static		클래스가 static으로 선언된 경우
				static 변수를 가지고 있다면 클래스는 static으로 선언해야 한다.
				외부 클래스의 static 멤버만 참조할 수 있다.

	Anonymous	참조할 수 있는 이름이 없는 경우		// 익명 내부 클래스	//	직접 구현하는 코드에 많이 나온다 / 무조건 할 줄 알아야 함.
				한 번만 사용하고 버려야 할 객체의 경우
*/

/*
	// 외부클래스 outer
	class outer		- int a							
					- disp()		-class InnerLocal	-int c		// 로컬 내부 클래스 2번
														-disp()

					- class	InnerMember	-int b		//멤버 내부 클래스 1번
										-disp()
					- static class InnerStatic	-int b		// 클래스를 static에 저장하는건 불가능, 그러나 내부 static 클래스는 저장 가능
												-disp()

// 위로는 클래스를 선언할 때 만들고
// 익명 내부클래스는 단독으로
	abstract class InnerAnony	-int e	만들 땐 아닌데 사용할 때 내부 클래스가 되
								-disp() 내부에 미완성인 애들(추상, 인터페이스)이면 익명내부클래스를 만들 수 있다.
		
*/


// class Outer
class Outer {
	private int a = 10;
	public void disp() {
		System.out.println("Outer a :" + a);
//		System.out.println("Outer 영역에서 InnerMember 안의 멤버 변수 b: " + b);	-> 이게 에러가 난다. 바깥에서 안에걸 참조하려고 하는데	/ 왜냐면 b는 지역변수니깐
			
			///////////////////// Member Inner Local Class ////////////////////
				/*메소드 내부에서 선언되고 메서드 안에서만 객체화 할 수 있다.
				메서드 외부에서는 사용할 수 없습니다.
				접근수정자(modifier)를 사용할 수 없다.*/
			
			class InnerLocal {
				private int c=30;
				public void disp() {
					System.out.println("InnerLocal a :"+ a);
					System.out.println("InnerLocal c :" + c);
				}
			}	// InnerLocal 끝
			InnerLocal il = new InnerLocal();
			il.disp();	// 로컬 내부 클래스는 이렇게 메서드 안에서만 쓸 수 있고 1회용으로 쓰고 버려야되	/ outer의 disp 가 실행이 되야 굴러강
			///////////////////// Member Inner Local Class ////////////////////
	
			
		


	}	// disp 메서드 끝	
	///////////////////// Member Inner Class ////////////////////
		/*
		Member		내부 클래스의 멤버 변수나 멤버 메서드들과 같이(같은 위치에) 클래스가 정의
		외부 클래스의 멤버를 참조할 수 있다.
		*/
		
		class InnerMember{
			private int b= 20;		// 지역변수
			public void disp() {
				System.out.println("InnerMember b : " + b);
				System.out.println("InnerMember 안에서의 Outer 클래스 a : " + a);	// -> 이건 에러가 안난다. 안에서 바깥을 접근하려고 하는데	// 지연변수임을 생각하자
			}
		}	// class InnerMember
		///////////////////// Member Inner class ////////////////////

		///////////////////// Static Inner class ////////////////////
		static class InnerStatic {
			private static int d=40;
			public void disp(){
			//	System.out.println("InnerStatic a : " + a);
				System.out.println("InnerStatic d : " + d);
			}
		}

		///////////////////// static Inner class ////////////////////
}	// class Outer

abstract class InnerAnony{
	// 재정의한 메서드에서 접근해야 하기 때문에 private 빼기
	int e = 50;
	public abstract void disp();
}	//InnerAnony

class InnerEx {
	public static void main(String[] args) {
		//Member Inner Class
//		InnerMember im = new InnerMember();	// 소속을 밝혀줘야 한다
//		Outer.InnerMember im = new Outer.InnerMember();	// 이래도 안되네?
		//소속.클래스타입 이름 = new 생성자
//		Outer.InnerMember im = new Outer(). new InnerMember();	// 된다
		Outer out = new Outer();	//멤버이너클래스는 외부 클래스객체가 꼭 있어야 된다	// 된다
		Outer.InnerMember im = out.new InnerMember();			// 된다
		im.disp();												// 된다
	
		// Local Inner Class
		out.disp();

		// Static Inner Class
		Outer.InnerStatic is = new Outer.InnerStatic();
	
		// Anonymouse Inner Class
//		InnerAnony ia = new InnerAnony();	// 추상클래스는 내부에 미완성인 애들이 있기 때문에 객체화가 불가능
		InnerAnony ia = new InnerAnony() {
			public void disp(){
				System.out.println("InnerAnony e : "+e);
				}
			};	// 객체생성도 안되고 상속도 못 받고 static 도 아니야 추상클래스나 인터페이스에다가, 어떻게 쓰느냐 생성자 뒤에 {} 구현부를 적는다.
		ia.disp();


		new InnerAnony(){
			public void disp(){
				System.out.println("InnerAnony2 e : "+e);
			}
		}.disp();	// 메서드를 이렇게 쓴다! 객체(인스턴스).메서드(); / 저 new 한 때 이미 인스턴스화 된 것이기 때문에
		
	}
}
