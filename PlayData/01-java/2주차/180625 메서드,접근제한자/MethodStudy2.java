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

class MethodStudy2 {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
	
	private int tmp;
	private int dan;
	
	
	public int input( ) throws Exception{
		while(true){
			System.out.print("2~9 중 한개 선택 :");
			tmp = Integer.parseInt(br.readLine() );

			if(tmp < 10 && tmp > 1){
				System.out.println("input 메서드의 매개변수가 입력값 "+tmp+" 를 받았습니다");
				dan = tmp;
				break;
				
			}else{ System.out.println("잘못된 값을 입력하셨습니다.(2~9에 해당하는 값을 입력)"); }
		
		}return dan;
	}	// int input 끝

	public void output(int x) {
			x = dan;
		for(int i=1; i<10 ;i++){
			
			System.out.println(x+" * "+i+" = "+(x*i));
		}
		System.out.println("");
	}	//void output 끝
	
	
		
		
		//이 밑으로 main 메서드

	public static void main(String [] args) throws Exception {
		MethodStudy2 m2 = new MethodStudy2();
		while(true){m2.output( m2.input() );}
	}	//main
	
}	//class