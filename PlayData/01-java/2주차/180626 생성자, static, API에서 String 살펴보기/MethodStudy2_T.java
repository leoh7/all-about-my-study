/*
****** 이거 시험에 냅니다 ******
버퍼드 리더로 받으세여

input() 메서드에서 정수를 입력받아서
output() 메서드에서 구구단을 출력한다.
2~9 사이의 값이 아니면 다시 입력 받는다.
단, input() 메서드에서 입력을 받게되면 예외가 발생하기 때문에
throws Exception 을 써줘야 한다.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class MethodStudy2_T {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		
		int dan = 0;
	
		
		public int input( ) throws Exception{
		do{
			System.out.print("단 입력 :");
			dan = Integer.parseInt(br.readLine());
		}while( dan<2 || dan>9 );
		return dan;
		}	// int input 끝

	

		

	public void output(int dan) {
		for( int i=1; i<10; i++){
			System.out.println( dan + "*" + i + " = " + dan*i );
		}
		
	}	//void output 끝
	
	
		
		
		//이 밑으로 main 메서드

	public static void main(String [] args) throws Exception {
		MethodStudy2_T m2 = new MethodStudy2_T();
		while(true){ m2.output( m2.input() ); }
	
	}	//main
	
}	//class