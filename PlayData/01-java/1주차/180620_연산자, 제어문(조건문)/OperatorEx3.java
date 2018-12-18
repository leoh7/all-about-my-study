class OperatorEx3 {
	public static void main(String[] args) {
	
/*
	and와 or의 연산 안하는 것을 보자
	다른 언어에서는 이걸 쓰는 것이 있어서 기억해둘 필요가 있다.
*/
	int a = 10, b = 10;
	//System.out.println( a-- > 8 && b-- > 10);		//이 경우 a : 9, b: 9
	System.out.println( a-- > 10 && b-- > 10);	//이 경우 b가 10이 나온다. 10보다 크냐고 안 물었다는 소리. &&는 앞에게 참이어야 뒤에게 참인지 거짓인지 알 수 있는데 앞에가 거짓이면 뒤에게 참이건 거짓이건 확인할 필요가 없으므로 컴퓨터가(두 개짜리 연산자는) 연산을 안 시킨다. 말인 즉슨 b--가 실행되지 않은 것.
	System.out.println( "a : " + a + "\t" + "b : " +b );

	a = b = 10;
	System.out.println( a-- > 8 || b-- > 10);
	System.out.println( "a : " + a + "\t" + "b : " +b ); // or의 경우 앞에가 참일 경우 뒤에는 볼 필요가 없다.

	}
}
