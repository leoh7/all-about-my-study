// 정수 세개를 입력받아 else if 로 비교 후
// 가장 큰 수 하나만 출력
// else if 로 푸세여
// 조건을 최소한으로 줄이는게 관건 (최대 3개)
// 숫자의 순서 상관없이!
import java.util.Random;
public class ElseIfStudy {
	public static void main(String[] args) {
	
	/*
	int a = Integer.parseInt( args[0] );
	int b = Integer.parseInt( args[1] );
	int c = Integer.parseInt( args[2] );
	아 숫자 넣기 너무너무 귀찮다....
	
	*/
	Random random = new Random();
	int a = random.nextInt(10);
	int b = random.nextInt(10);
	int c = random.nextInt(10);
	int d = random.nextInt(10);

	System.out.println("첫 번째 입력값 : " + a);
	System.out.println("두 번째 입력값 : " + b);
	System.out.println("세 번째 입력값 : " + c);
	System.out.println("세 번째 입력값 : " + c);

	if( a >= b && a >= c )System.out.println(a);	//굳이 등호가 필요하지 않았다
	else if( b >= c )System.out.println(b);
	else System.out.println(c);

	System.out.println("\n");
	System.out.println("\n");
	
	if( a > b && a > c && a > d )System.out.println(a);	
	else if( b > c && b > d )System.out.println(b);
	else if( c > d )System.out.println(c);
	else System.out.println(d);
/*
a 탈락 b 탈락 c 탈락 =>d
이렇게 하는게 아니라
	if( d>a && d>b && d>c) System.outprintln(d);	//이렇게 한 줄만 추가 해서 간단히 수정하는게 훨씬 좋다.
	if( a>b && a>c )System.out.println(a);	
	else if( b>c )System.out.println(b);
	else System.out.println(c);
*/

/*	이걸론 안됨
	a > b 인가?
	b > c 인가?
	c > a 인가?
		3 4 5
		아니요
		아니요
		네 -> 출력

		5 4 9		//오류
		네 -> 출력

		3 5 4
		아니요
		네 -> 출력

		4 5 3
		아니요
		네 -> 출력
*/

	}
}
