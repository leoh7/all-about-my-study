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
class WhileStudy2_3 {
	public static void main(String[] args) throws Exception{
	
		BufferedReader	br = new BufferedReader( new InputStreamReader( System.in ));	
		
	/*선생님 코드
	do{
		int cnt = 0, sum = 0;
		for( int i=0; i<10; i++){		//10문제니까 for 로 10개 해주구요
		int a = (int) (Math.random()*100)+1;
		int b = (int) (Math.random()*100)+1;	//10문제를 내야하기 때문에 반복문 안에 들어가야한다.
		}
		System.out.print("["+(i+1)+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = 입력값
		int answer = Integer.parseInt( br.readLine() );	// 입력값을 받아서 answer에 대입
												//무조건 처음부터 한번에 다 하려고 하면 안된다. 되고 있는지 지속적으로 확인해가면서 해야해
		if( a+b == answer){
			cnt++;
			sum += 10;
		} else {
		}											

		char yn = null;		//에러								//yn이 안에 있으면 do{} 하고 닫히니 while이 인식을 못한다. 밖으로 빼줘야 함
		char yn = '\0'		//1바이트로 null 이라는 소리
		char yn = '\u0000'	//2바이트로 null 이라는 소리
		char yn = 0			이렇게 해도 되, 어차피 char는 숫자 문자 다 들어가니깐

		System.out.print("더할거냐");
		yn = (char) System.in.read();	//이제 대문자와 소문자 구분만 하면 됨
		System.in.read();
		System.in.read();

	}while(yn == "Y" || yn == "y");
	*/

	outer:
		while(true){			//문제 풀기
			
			int queNum = 0;

			for(int i=1 ;; i++){
				if(i == 11)break;	
				int a = (int)(Math.random() * 100) + 1;				// Math.random() 은 0.999999999~ 까진 난수가 생성이 되는데 1.0은 생성이 안되/ 그래서 int 형변환과 (*100) 을 해도 0~99 까지만 생성이 되는것 / 하여 + 1을 해준다 / 만약에 1~45까지의 난수를 발생시키고 싶다? / 그럼 *45를 곱하고 뒤에 +1 하면 되는 것 
				int b = (int)(Math.random() * 100) + 1;

				int plusValue = a + b;

				System.out.print("["+i+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = 입력값
				
				
				int answer = Integer.parseInt( br.readLine() );			//사용자 입력
				
				if(plusValue == answer){								//만약에 plusValue 랑 answer
					queNum++;											//문제 번호 +1
					System.out.println("맞았습니다 "+"\n"+"현재 맞은 갯수:"+queNum);
					System.out.println("");
					
				}else{
					System.out.println("틀렸습니다");
					System.out.println("정답 : " + plusValue);
					System.out.println("");
				}

			}System.out.println("총 맞은 갯수 : " + queNum);

			question :
			for(;;){
				
				System.out.println("더 하시겠습니까? Y(y) or N(n)");
				String yN = br.readLine();
				switch(yN){
					case "Y": break question;
					case "y": break question;
					case "N": break outer;
					case "n": break outer;
					default : System.out.println("Y(y) or N(n) 값을 입력하세요");

				}
			}




		//	for(;queNum==10;){			//더 할거냐 말거냐 case?
		//	}
		}
		//System.out.println("수고하셨습니다");

		
	}
}
