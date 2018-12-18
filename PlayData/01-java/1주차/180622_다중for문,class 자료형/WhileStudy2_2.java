

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

class WhileStudy2_2{
/*
	클래스명	WhileStudy2_2
속성		String regame;
메서드	setRegame
		getRegame
*/




	//아래부터는 실행부분
	public static void main(String[] args) throws Exception{
		BufferedReader	br 
		= new BufferedReader( new InputStreamReader( System.in ));					//입력 버퍼를 읽어오는 클래스 / 여태 쓰던 패키지랑 달라 / 입출력 관련 패키지는 경로설정을 해야해	
		String regame;
		//int answer = Integer.parseInt( br.readLine() );				//int a = br.readLine(); 이렇게 하면 에러. 얘가 쭉 한줄로 (엔터까지 한줄로) 인식해. 그리고 돌려주는 값이 문자열이야	



		Loop1 : while(true){
			int queNum = 0;

			for(int i=1 ; i<=10 ; i++){
				
				int a = (int)(Math.random() * 100) + 1;				// Math.random() 은 0.999999999~ 까진 난수가 생성이 되는데 1.0은 생성이 안되/ 그래서 int 형변환과 (*100) 을 해도 0~99 까지만 생성이 되는것 / 하여 + 1을 해준다 / 만약에 1~45까지의 난수를 발생시키고 싶다? / 그럼 *45를 곱하고 뒤에 +1 하면 되는 것 
				int b = (int)(Math.random() * 100) + 1;
				int plusValue = a + b;
				

				System.out.print("["+i+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = 입력값
				int answer = Integer.parseInt( br.readLine() );			//사용자 입력
				
				if(plusValue == answer){								//만약에 plusValue 랑 answer
					queNum++;
					System.out.println("맞았습니다 "+"\n"+"현재 맞은 갯수:"+queNum);
					System.out.println("");
					
				}else{
					System.out.println("틀렸습니다");
					System.out.println("정답 : " + plusValue);
					System.out.println("");

				}


			}
			System.out.println("총 맞은 갯수 : " + queNum);
			System.out.println("더 하시겠습니까? Y(y) or N(n)");
				
				

				regame = br.readLine();
				
				for(;;){

				if(regame == "N" || regame == "n"){
				System.out.println("고생하셨습니다");
				break;
				}
				if(regame == "Y" || regame == "y")

				break Loop1;
				}else{
				System.out.println("Y(y) or N(n) 값을 입력하세요");
				}

				}
		}
				

			
				/*
				if(regame == "Y" || regame == "y"){
				}else if(regame == "N" || regame == "n"){
				System.out.println("고생하셨습니다");

				break;
				}else{
				System.out.println("Y(y) or N(n) 값을 입력하세요");
				}
				*/
			
	
		}	//while
	}	//main
	//class
