/*
제네릭
컬렉션에서 많이 쓰여요
C++에서 나온 개념. 맨 마지막에 나온 문법 중에 하나가 템플릿
그걸 가져다가 쓴 게 제네릭 / 1.5버전부터 들어왔다.
	1.4 버전까지는 이 개념을 안 썼다는 얘기. 다른 개념을 썼다.
	////// 예전 방법 //////
	클래스가 다 좋은데, 사용하는데 제약이 있어
	컬렉션이라는게 배열이라는 것을 대체해서 나온 것.
		배열은 무슨 문제가 있냐.
		C같은 경우는 배열을 int m[5]; 이렇게 잡았어. / 배열을 이렇게 만들었다가 중간에 뭘 끼워넣고 싶어, 그러면 된다고 생각을 해, 
			C에서는 데이터가 늘었다 줄었다 그래, 그러면 방을 아예 크게 잡아놓고 작업을 하기도 해(이렇게 작업하면 못하는 사람)
			그래서 C에서는 Linked List 라는 걸 써. 이러면 난이도가 높아져, 코드를 알아도 3시간(기본)은 걸려.
			C로 취업하러가면 Linked List 짤 줄 아냐고 반드시 물어본다고 했지. 어려워
		C의 템플릿은, 자료형을 안 정해서 만드는 것, 사용할 때 정한다.

	컬렉션은 배열과는 다르게 방을 따로따로 잡아서 연결을 시켜서 사용한다. / 불연속적인 메모리를 연속화 시키는 작업 / 하나의 장점 / 배열은 연속적으로밖에 못했었지.
	배열은 중간에 끼워넣거나 뒤에 끼워넣거나 중간 삭제가 불가능했는데 / 원래 불연속적인 메모리였기 때문에 순서만 연결하는게 가능 / 메모리 활용에 장점이 있다.(Linked List가 이런 것)
	그래서 이런 자료구조 / (자료구조)많은 양의 데이터를 관리하기 편하도록 만들어놓은 프로그램 / 
	
	자바는 없었냐? 있었어. 근데 문제가 있어서 제네릭으로 바꿔서 쓰기 시작한거야. 근데 전부다 바꾸진 못해서
	두가지 방법을 다 알아야 하고, 두가지 방법의 차이도 알아야 하고, 왜 이런 방식을 써야 하는지 도 알아야 해.
	
	최고 조상 Object 이용
	문제 : 다 들어간다. 아 막 섞여서 마셔 콜라랑 우유랑 물이랑.
	객체가 컵이야. 거기에 담으니깐(실수 넣을래)
	근데 문자가 들어가. 최고 조상님이라.
	각각 하는 역할이 다를 수 있는데, 모든게 다 들어가게 되니까 도리어 좋은게 아니게 됨.
		그래서 안쓰던 템플릿을 가져다가 제네릭으로 쓰게 됨.
		컵 하나에다 섞어 먹지 말자! 콜라 컵 따로 써라! 우유랑 섞지 말고
		대신 이렇게 쓰려면 컵마다 이름을 붙여야겠지?? Object로 받으면 표시를 못 해.

	
제네릭 클래스를 갖다 쓸 때는,
반드시 명시를 해줘야 되. 이름붙이기. 그걸 안 하면 제네릭이 안 먹습니다.
지금은 1.8을 쓰지만 api에는 제네릭 이전에 쓰던 방식도 남아있다.

*/


/*	이렇게 하면 int 형 자료는 받을 수 있지만 다른 자료형을 받으려면 각각 전부 다 만들어 줘야 한다
	순수한 노가다가 되는 것.
class Generic {
//멤버 변수
	private int a;
//생성자
	public Generic(int a){
		this.a = a;
	}	// Generic 생성자
//멤버 메서드
	public void setA(){
		this.a = a;
	}	// void setA()
	public int getA(){
		return a;
	}	// int getA()

}	// class Generic
*/


/*	이 경우엔 Object 형으로 변수를 잡았다. 이런식으로 넣어놓으면 들어가기야 다 들어간다마는
	int만 받아야 할 자리에 String이고 자시고 전부 다 들어가게 되는 것.
	선언까지야 에러 없이 진행 될 수 있겠지만 구현하고 연산하는 과정에서 치명적인 오류가 생겨도 여타 에러 메세지 없이 통과해 버릴 수 있다.
class Generic {		// 너무 다 받아줘서 문제다.
	private Object a;
	public Generic( Object a ){	// Object 에 들어갈 때는 int 가 Integer 로 들어감. 오토박싱
		this.a = a;
	}

	public void setA(Object a){
		this.a = a;
	}
	public Object getA(){
		return a;
	}
}

class GenericEx1 {
	public static void main(String[] args) {
		Generic ge1 = new Generic(10);
		System.out.println("ge1 : " + ge1.getA() );

		Generic ge2 = new Generic(10.5);	// 어렵게 짠 클래스인데 실수도 관리하고 싶어!  / 근데 안 받아줌 / 위에는 int만 관리하게 만들어 놨기 때문에
		ge2.setA("ABC");	// 이게 되버리는게 Object를 가지고 했을 때의 문제/////////////////////////////////////////////////////////
		System.out.println("ge2 : " + ge2.getA() );

		
	}	//main
}	// class GenericEx1
*/	// 제네릭 사용 전



class Generic <T>{	// API 에는 E 라고 많이 되어있다. element, 지금 T는 자료형Type의 약자로 그냥 써놓은 것. 뭐라 쓰든 일치만 시켜주면 된다.
	private T a;
	public Generic(T a){
		this.a = a;
	}
	public void setA(T a){
		this.a = a;
	}
	public T getA(){
		return a;
	}
}

class GenericEx1{
	public static void main (String[] args){
		/*Generic ge1 = new Generic(10);
		System.out.println("ge1 : " + ge1.getA() );
		Generic ge2 = new Generic(10.5);
		ge2.setA("ABC");
		System.out.println("ge2 : " + ge2.getA() );*/

		Generic <Integer> ge1 = new Generic<Integer>(10);	// 요기 Integer 자리에다 int 쓰면 안됨. 예전에 배울 때 말했던 자리가 여기 / 항상 통일해서 써야 됐던가?
		System.out.println("ge1 : " +ge1.getA() );		

		Generic <Double> ge2 = new Generic<Double>(10.5);
//		ge2.setA("ABC");		// 이제 이거 안된다. 객체 하나에 섞어쓰기!
		System.out.println("ge2 : " +ge2.getA() );
		//ge1 은 Integer 형 자료만 받게 되고
		//ge2 는 Double 형 자료만 받게 되었다!
	}
}

