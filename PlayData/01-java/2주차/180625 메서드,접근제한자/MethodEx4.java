/*
오버로드 Overload
메소드명은 같은데 매개변수의 자료형이 다르거나
개수가 다를 때
순서가 다를 때 다른 메서드로 취급한다.
*/

class MethodEx4 {
	public void hap( int a, int b ){		//매개변수가 받고 //int a = 5, b = 2 요런식으로 받은 것.
											//int a = 2.5, b = 4.7 이렇게 넣은 것.		
		System.out.println("합 : "+ (a+b));
	}
	public void hap( double a, double b ){
		System.out.println("합 : "+ (a+b));

	}
	public void hap(int a, int b, int c){
		System.out.println("합 : "+ (a+b+c));
	}

	public static void main (String [] args){

		MethodEx4 me = new MethodEx4();
		me.hap( 5 , 2 );					//인자를 던지고
		me.hap( 3 , 7 );
	//	me.hap( 2.5, 4.7 );		// 오버로드 구현 전 요건 에러가 난다. / 8바이트잖아(double)	/ int 는 4바이트고 // 그냥 단순히 자료형이 달라서가 아니라, 크기의 문제임
		me.hap( 2.5, 4.7 );		// 오버로드 구현 후 실행이 가능해짐!
		me.hap( 2, 5, 7 );
	}
}
/*
C 때는 int 두 개를 받으려면
hapInt( int, int )			// int 두개 받는 애를 굳이 직접 찍어서 줘야 되
hapDouble( double, double )

C++ 로 와서
hap( int, int )				// 그냥 합으로 호출하면서 int 두 개 던지면 int 두 개 받고, double 두 개 던지면 double 두 개 받는거야 / 이거 무척 편한거임
hap( double, double )
이 가능해졌다.

오버로드의 장점은 무엇이냐		// 
호출에 장점이 있음.

cf) Override 랑은 완전히 다른 개념이므로 주의
*/