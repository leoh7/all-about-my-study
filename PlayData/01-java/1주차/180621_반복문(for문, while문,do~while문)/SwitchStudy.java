/*
숫자 두 개와 연산자 ( + - * / % ) 한 개를 입력받는다.
입력받은 연산자로 입력받은 숫자를 계산한 후 출력한다.
단 나눗셈은 실수로 출력한다.
연산자( + - * / % ) 이외에는 "잘못입력" 출력
ex) 입력 :	2 5 +
	출력 :	2 + 5 = 7


	과제를 위한 설명
	연산자 스위치 케이스를 만들어 오는 것이 숙제
	오늘 이후로 args 받는걸 안쓸거임, 시작 할 때만 입력을 받을 수 있기 때문에 지금처럼 중간중간 여러번 받는게 불가능.

	입력받을 때 이제 쓸 것이 
	System.in.
	cf) System.out

	System.in.read() - 48;	//-48에 대한 설명


							//48?
	read라는 애가 돌려주는게 정수값. 입력받은걸 정수로 돌려줘 한글자 밖에 못 줘서(의미없는 이야기 안쓸 내용 필요없는 내용 설명서에 써있는 내용)
	우리의 목표는 도큐멘테이션을 읽는 것!
	read가 한 글자를 받는데 문자로 받지? 숫자로 돌려주는데 당연히 아스키 코드 값으로 바뀌겠지'2'
	그럼 48을 문자로 주니까 50 그래서 -48을 빼준거임

			운영체제는 프로그램이 물 흐르듯이 흐를 거라 생각한다.
		운영체제는 문제가 되서 갑자기 멈추면(interupt) 그냥 꺼버림
		데이터 입력을 받을라고 일부러 멈춘건데 이 때 예외가 발생됨
		예외처리는 클래스 다 배우고 배울거임 3주차쯤?
		우리가 일부러 멈춘거야 라는 예외처리가 들어있다. 입력받을 때는 항상 예외처리를 만들어 놓은 것.
		try - catch 로 안하고 throws 로 예외를 던져버릴거임
		입력받을 때는 항상 써야함

	System.in.read	//단점
	read는 오늘만 쓰고 또 안쓸거야
	얘는 한글자밖에 입력을 못받아. 2글자를 입력하면 값이 밀려서...0~9까지만 입력 받을 수 있다는 얘기
					//왜 자꾸 나오냐?
		버퍼에 대한 이야기
		버퍼란 메모리에 잡아놓는 임시기억장소.
		여기만 쓰이는게 아니라 장치들이 데이터를 주고받는데 장치마다 속도가 다르고 
		저쪽 장치가 다른 작업을 하고 있으면 못 받으니까
		데이터를 주고받는 모든 장치는 완충역할을 하는 임시기억장치를 갖고 있다.
		문서편집할 때도 바로 입력하는게 보이는 것 -> 키보드 버퍼에 쌓인다.
		모니터에 출력할 때는 바로 출력하는 것처럼 보이지만 -> 출력 버퍼에 쌓이는 것.
		****입력받아라 하는 애들은 데이타가 없으면 기다리고 데이터가 있으면 그냥 줏어간다****
		2하고 엔터를 쳐서 넘어가는게 아니라 버퍼에 줬으니까 입력받은 애들이 그걸 줏어가는 것( 2 와 엔터 )
		System.in.read() - 48;	
		System.in.read();	//엔터는 밑으로 내려와라, 앞으로 가라 이렇게 버퍼가 두개 진행됨 
		System.in.read();	//엔터 두개를 빼버리는 것 두개
	
	System.out.print5
	커서 위치가 옆에 있게 하려고 해놓은 것

	나중엔 여러가지 방법으로 입출력을 받을 것이다.
*/

class SwitchStudy {
	public static void main(String[] args) throws Exception	{
		
		System.out.print("정수 : ");
		int a = 
		System.in.read() - 48;
		System.in.read();
		System.in.read();

		System.out.print("정수 : ");
		int b = 
		System.in.read() - 48;
		System.in.read();
		System.in.read();

		System.out.print("연산자( + - * / % ) : " );
		char c = (char) System.in.read();				//왜 강제형변환을 해줬을까? read는 키보드로부터 받으면 숫자로 돌려줌 (int로 43) int는 4바이트 char는 2바이트. 짤린다. 그래서 형변환

		//이 밑으로 switch ~case 를 쓰세여
		//이걸 잘해야 3주차 쯤 받을 개인과제를 잘 풀 수 있다.(평가 들어감)
		//연산자( + - * / % )
		switch(c){										// ()안에는 정수int, 문자char, 식(정수로 떨어지는 식)만 올 수 있다. 
		case '+' : System.out.println( a + b );break; 
		case '-' : System.out.println( a - b );break;
		case '*' : System.out.println( a * b );break;
		case '/' : System.out.println( a / b );break;
		case '%' : System.out.println( (double)a % b );break;
		default : System.out.println("잘못입력");
		}	// switch ~case
	
	
	}	//main throws Exception

}	//class
