// 다중상속이 된다.
// 클래스는 형태가 있는 애들. 두 개를 가져오면 충돌이 난다
// interface는?
// 변수는 static 이기 때문에 충돌 날 일 없음.	/ 메서드는 구현도 안 된 가상.	/ C에서의 vituar?? 함수였다고?	/ 

interface Inter2 {
	int b=20;
	public int getB();
}

//class InterEx2 implements Inter1, Inter2 {	// Inter1 번이 없는데 그냥 이렇게만 써도 / 앞 예제에서 컴파일 했을 때 Inter1번 클래스가 생겼어, 그걸 다른데에다 쓰고 있는거	// inter1 의 접근제한자가 default였었지
class InterEx2 implements Inter1, Inter2 {
	public int getA(){ return a; }
	public int getB(){ return b; }

	public static void main(String[] args)	{
		InterEx2 ie = new InterEx2();
		System.out.println("a : "+ ie.getA());
		System.out.println("b : "+ ie.getB());
	}
}
