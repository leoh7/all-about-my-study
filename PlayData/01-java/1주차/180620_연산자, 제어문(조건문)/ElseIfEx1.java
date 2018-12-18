/*

	제어문	조건문
			-if( 조건 ) 참;
			-if( 조건 ) 참;
			else 거짓;
			-if( 조건 ) 참;
			else if( 조건 ) 참;
			...
			else 거짓;
			-switch ~ case

			반복문
			-for
			-while
			-do ~ while

*/

class ElseIfEx1 {

/*
else if는 언제 쓰냐! 왜 쓰냐?


90점 이상 A학점
80점 이상 B학점
70점 이상 C학점
60점 이상 D학점
50점 이상 F학점
					75점이라고 하자
		if( a >= 90 && a <= 100 ) System.out.println( "A학점" );		//거짓
		if( a >= 80 && a < 90 ) System.out.println( "B학점" );		//거짓
		if( a >= 70 && a < 80 ) System.out.println( "C학점" );		//참. 참이지
		if( a >= 60 && a < 70 ) System.out.println( "D학점" );		//왜 또 물어봐
		if( a >= 0 && a < 60 ) System.out.println( "F학점" );			//또 물어봐 왜

		이렇게 else if 를 쓰지 않으면 참이 나와서 빠져나와도 되는 경우에도 계속해서 질문을 시도한다.
		else if 로 프로그램을 짜면 딱 하나 걸리면 그 다음 더 이상 질문하지 않는다.
		거기에 더해 조건문이 연관 없이 따로따로인데 else if 를 쓰면 위의 조건이 틀렸을 때만 내려가기에
		하나로 통합된다는 것
		cf) 조건을 순차적으로 줘야한다 B, C 위치를 바꾸면 C 학점도 참이기에 C학점이 나와버림


					//주석과 본문이 아주 똑같은 건 아니다. 105점과 -50점을 생각해보자.
*/

	public static void main(String[] args) {
		
		int a = Integer.parseInt( args[0]);

		if( a >= 90 ) System.out.println( "A학점");
		else if( a >= 80 ) System.out.println( "B학점");
		else if( a >= 70 ) System.out.println( "C학점");
		else if( a >= 60 ) System.out.println( "D학점");
		else System.out.println( "F학점");					//나머지 라는 의미, 위의 조건이 전부 거짓이면 이걸로 해 라는 것
		//else if( a < 60 ) System.out.println( "F학점");		//이건 나머지 는 아니야 조건을 물어본거지

	}
}
