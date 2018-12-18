/*

메서드(Method)	// 선언 / 구현->호출(호출 안해도 상관없다)		// 호출 -> 선언 / 구현(없으면 안됨)
독립된 프로그램						// System.out.println 만 넣어도 됐다. / 메서드는 "한 가지 일만" "완벽하게" 끝내면 된다. 여러가지 일을 시키면 안 좋아. / 우리가 지금 할 거는 '사용자 정의 메서드' / 
반복되는 내용을 묶어서 처리			// 이게 메서드가 나온 이유 / 프로그램은 팀 작업 = 수정하기 편하게 짜는게 최고다 최고 / main안에는 메서드 만들면 안되. 메서드 안에 메서드 만들면 안되(자바 한정) / 위에다 묶어놓고 불러다 쓰면 되. 이걸 "호출" / 
반드시 호출한 곳으로 되돌아 온다		// 여기서 제일 중요한 얘기임 / "호출" 을 하면 main 에서 해당 메서드가 있는 클래스에서 실행하고 main으로 돌아온다.
인수는 개수에 상관없다.				//
return 값이 없으면 void 다.		//
return 값은 한 개 뿐이다.			//

*/
// 클래스를 갖다 쓰는 방법 5가지를 쓰세요 시험문제 낸다고 했어요?
// 1번 객체를 생성한다.
class MethodEx1 {
	public void sub(){	// 선언	/ 구현 이 같이 되어 있는 모습 / 선언부가 "public void sub();"
		System.out.println("Hellow Java!!!");	
	}



 public static void main(String [] args){
//	sub();	/ 이게 호출	/ static 영역에다 넣은 건,(잡아라 말아라)메모리 할당을 안 받아도 자동으로 된다.  / 그래서 그 전까지 main 안에 넣어놓은건 그냥 실행이 된거여. / main 안에만 넣어서 썼었으니깐 / 
	 
	 MethodEx1 me = new MethodEx1();
	 me.sub();		//호출
	 me.sub();
	 me.sub();

 }

	

/*	실행할거냐 갖다 쓸거냐에 따라 main 메서드는 넣을까 말까 생각하는 것. / 단 하나의 프로그램은 항상 하나의 main. main이 시작이라 두개면 충돌이 나.
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
*/
}
