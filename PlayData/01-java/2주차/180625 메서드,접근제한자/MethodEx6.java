//정수 세 개를 입력받아서 가장 큰 수 하나만 출력

import java.io.BufferedReader;
import java.io.InputStreamReader;

class MethodEx6{
	
	public int big(int a, int b, int c){
		if(a > b && a > c) return a;
		else if(b > c) return b;
		else return c;		//나머지는 다 이걸로 한다, 라는 것이 필요하다. 여지를 주면 안됨

		//System.out.println(" ");	//return 밑에는 뭘 줘도 에러가 난다!
	}
	
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	
	System.out.print("정수 1 : ");
	int a = Integer.parseInt(br.readLine() );

	System.out.print("정수 2 : ");
	int b = Integer.parseInt(br.readLine() );

	System.out.print("정수 3 : ");
	int c = Integer.parseInt(br.readLine() );
	
	MethodEx6 me = new MethodEx6();
	System.out.println("가장 큰 수는 "+ me.big(a,b,c) );

		for(int i=0;i<=20;i++){
		i =	me.big(a,b,c);
		}
	}	//main
}	//class