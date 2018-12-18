	/*
		변수		변하는 값 / 메모리할당		기본값
		논리형	boolean		1bit		false
		문자형	char		2byte		/u0000 <=null
		정수형	byte		1byte		0 
				short		2byte		0
				int			4byte		0
				long		8byte		0
		실수형	float		4byte		0.0	소수점 7자리까지
				double		8byte		0.0 소수점 14자리까지
	*/

class VariableEx1{
	public static void main(String[] args) {
		boolean a = true;
		System.out.println("boolean :" + a);
		
		char b = '월';
		System.out.println("char :" + b);

		//byte c = 128;
		//System.out.println("byte : " + c);
		//숫자가 너무 크기 때문에 오류
		//실제로 1바이트가 표현할 수 있는 범위는 -128~127 하나는 부호 방
		byte c = 127;
		System.out.println("byte : " + c);

		/*
		float d = 5.0;
		System.out.println("float : " + d);
		오류
		float은 수가 크고 작음의 문제가 아님. 
		유일하게 방을 잡았을 때 못 넣는 것은 방보다 큰 데이터
		5.0은 기본으로 double => 8바이트 짜리를 4바이트(float) 방에 넣으라고 한 것
		*/
		float d = 5.0F;
		System.out.println("float : " + d);
		
		String e = "ABC";
		System.out.println("String : " + e);
		
		//형변환
		int num1 = 5;
		double num2 = 5.5;
		

		//int res1 = num2;
		//오류
		int res1 = (int)num2;
		System.out.println("res1 :" + res1); //0.5는 잘리고 5만 나온다

		double res2 = num1; //자동형변환
		System.out.println("res2 :" + res2);
	
	}
}
