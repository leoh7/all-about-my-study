class OperatorEx2 {
	public static void main(String[] args) {
	 //비트연산자 이다.
	 //2진수 값을 가지고 연산을 하는 것. 
	int a = 12, b = 20;
	System.out.println( "a&b : " + (a&b));	//4
	System.out.println( "a|b : " + (a|b));	//28
	System.out.println( "a^b : " + (a^b));	//24


	System.out.println( true && true );
	System.out.println( true && false );
	System.out.println( false && true );
	System.out.println( false && false );

	//System.out.println( true && false || true );	//true
	
	System.out.println( true || true );
	System.out.println( true || false );
	System.out.println( false || true );
	System.out.println( false || false );

/*
비트연산자(비트로 하는건 안씀 |만 딱 한번 쓸거)
    & | ^ ~         ~(1의 보수 연산자 / bit not) 는 1번 우선순위(이따 따로 애기할거임)
    비트 논리 연산자(두개씩은 논리연산자) 논리값을 주는게 아니라 숫자를 줌

    short a = 5;
    0000 0000 0000 0101     5
~a 1111 1111 1111 1010     -6 (양수랑 음수랑 반을 접어서 겹쳐서 양수 5에 대비되는 음수가 -6, -5가 안 구해진다)
-a 1111 1111 1111 1011     -5 (이게 2의 보수 연산자/ 이게 시험에 나옴->)
쉽게 생각하기 0을 더한다음 -1를 한번 더해주면 됨

9의 보수 연산자 -> 뺼셈을 위한 연산자/ 필요없음

bool 연산? boolean 연산?
(이걸로 쓰는 언어도 있음)
and	or	Xor
x	y	x&y	x|y	x^y
0	0	0	0	0
0	1	0	1	1
1	0	0	1	1
1	1	1	1	0


비트 논리연산의 단점 OperatorEx2.java 
정수를 정수 그대로 받질 않는 것?
int a = 12;
    ...     0000 1100
int b = 20;
    ...     0001 0100

a & b     0000 0100        4
a | b      0001 1100          28
a ^ b     0001 1000         24
*/
	}
}
