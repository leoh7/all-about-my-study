/*
매개변수		//던진 데이터를 받아서 내부에서 쓸 수 있게 하는 것	/ 던지면 받아야되, 안 던지면 받으면 에러나 / 던졌는데 안 받으면 에러나 / 메서드에 값을 던지는 자리가 똥그라미 괄호
인수, 인자, argument, parameter
5와 2 값의 합 차 곱 몫을 구해서 출력


*/

class MethodEx3 {
	//int a=5, b=2;	// 전역변수(멤버 변수)	/ 이러면 되는데 숫자를 5랑 2만 쓸 거 아니잖아. 매개변수
	
	public void hap(int a, int b) {		//int a , int b 가 매개변수
	//	int a=5, b=2;	// 지역변수	/ 이 예제에서는 계속 반복되기 때문에 전역변수(멤버 변수) 로 쓰는 것이 낫겠다
		System.out.println("합 : "+ (a+b));
	}
	public void cha(int a, int b) {
	//	int a=5, b=2;	// 지역변수
		System.out.println("차 : "+ (a-b));
	}
	public void gop(int a, int b) {
	//	int a=5, b=2;	// 지역변수
		System.out.println("곱 : "+ (a*b));
	}
	public void mok(int a, int b) {
	//	int a=5, b=2;	// 지역변수
		System.out.println("몫 : "+ ( double)a/b );
	}

	
	
	public static void main(String[] args){	// 괄호 안에서 데이터 받으면 매개변수 / args 는 변수
		//int a=5, b=2;		/ 이렇게 하면 에러가 8개가 난다 ㅋㅋ
		int a=5, b=2;
		MethodEx3 me = new MethodEx3();
		//me.hap(a, b);		/2개 던졌는데 3개,1개 받으면 에러나 / 
		me.hap(a, b);		//여기에 a, b가 인수, 인자, argument, parameter
		me.cha(a, b);
		me.gop(a, b);
		me.mok(a, b);
	}

/*
던지는게 인수, 받는게 매개변수
*/

}