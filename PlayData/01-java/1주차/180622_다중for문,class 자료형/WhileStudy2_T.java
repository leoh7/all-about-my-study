/*WhileStudy2
1~100사이의 난수를 2개 발생하여 덧셈을 맞추는 게임
10문제만 풀기
[1]	ran1 + ran2 = 입력값
[1] 25+ 36 = 100	//25, 36 난수 / 100 입력 값
틀렸다...
정답 : 61

[2] 50 + 36 = 86
맞았다
...

//[10] 끝난 후
정답 개수 : XX개
점수 : XX점

문제를 더 풀지를 묻는다.
'Y' 또는 'y' 입력되면 다시 10문제를 출제한다.
'N' 또는 'n' 입력되면 프로그램 종료


여태까지 쓰던 시스.인으로 입력값을 받질 못해 하나만 받으니까
그래서 IO 쓰잔거 하나 쓸꺼야


문제 10개 반복문 하나
돌아 올거냐 말거냐 반복문 하나
*/

import java.io.BufferedReader;		//import의 . 은 폴더를 의미	//나중엔 2,30개 될거임
import java.io.InputStreamReader;
class WhileStudy2_T {
	public static void main(String[] args) throws Exception{
	
		BufferedReader	br = new BufferedReader( new InputStreamReader( System.in ));	
		char yn = 0;
	//	char yn = null;			//에러								//yn이 안에 있으면 do{} 하고 닫히니 while이 인식을 못한다. 밖으로 빼줘야 함
	//	char yn = '\0';			//1바이트로 null 이라는 소리
	//	char yn = '\u0000';		//2바이트로 null 이라는 소리
	//	char yn = 0;			//이렇게 해도 되, 어차피 char는 숫자 문자 다 들어가니깐


	do{
		int cnt = 0;
		int sum = 0;
		
		
		for( int i=0; i<10; i++){				//10문제니까 for 로 10개 해주구요
			int a = (int) (Math.random()*100)+1;
			int b = (int) (Math.random()*100)+1;	//10문제를 내야하기 때문에 반복문 안에 들어가야한다.
			
			
			System.out.print("["+(i+1)+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = 입력값
			
			int answer = Integer.parseInt( br.readLine() );	// 입력값을 받아서 answer에 대입
			
			
			if( a+b == answer){			//참
				cnt++;
				sum += 10;
			} else {				//거짓
			}											
		}	// for i

		System.out.println("맞은 갯수 : "+ cnt);
		System.out.print("더할거냐 Y or N");
		yn = (char) System.in.read();	//이제 대문자와 소문자 구분만 하면 됨
		System.in.read();
		System.in.read();

	}while(yn == 'Y' || yn == 'y');





		}	// main

		
	}	// class

