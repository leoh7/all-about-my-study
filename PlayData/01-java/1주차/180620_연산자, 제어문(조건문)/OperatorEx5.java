class OperatorEx5{

//명령줄 인수
//명령줄로 인수를 받을 것임
//데이터 입력 방식
// 명령줄 입력, (앞에서 단점을 보완) <= IO(인풋 아웃풋/난이도가 높다) 대신에 써보는 것
	
	public static void main(String[] args) {
		
	int a = Integer.parseInt( args[0] );	//a가 무슨 값인지 모름. 이건 입력 받을 값. //미리 정의 할 수 있나? 한 개일 땐? 두 개일 땐?
	// a = 5; 라고 대입해봐도 결과가 나오지 않는다.
	System.out.println( a % 2 == 0 ? "짝수" : "홀수" );	//삼항연산자의 장점은 위치를 안가리고 다 들어간다(문장임에도 불구하고 연산자임), 단점은 간단한 조건밖에 안됨
							//	조건	?	참 :	거짓
							// a 를 2로 나눈 나머지(%)가 0이랑 같냐(==)? (참이면)"짝수" : (거짓이면)"홀수" 를 출력(Sysout)
	
	/*
	C는 이게 됨
	a%2==0 ? System.out.println("짝수") : System.out.println("홀수")
	삼항연산을 먼저 입력하고 뒤에 문장을 출력해라
	문장을 넣는건 되는데, 연산자다 보니까 저렇게 단독으로 앞에다 쓰는 것이 안됨.
	*/
	}
}
