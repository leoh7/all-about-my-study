class WhileStudyT{
	public static void main(String[] args) {

		int rand = (int)(Math.random()*10);
		int cnt = 0;

//		{
//			int a = 0; //요런것도 활용한다. {}안에서만 딱 쓰고 버릴 것
//		}

		whlie(true){
			cnt++;		//cnt를 0부터 시작하게 하고 증감값을 위에다 주셨네. 깔끔하다
			System.out.print("찍어봐(0~9) : ");
			
			int answer = System.in.read() - 48;	//띄어쓰기 아스키코드 32 다
			System.in.read();
			System.in.read();

			if( rand == answer ){
				System.out.println(cnt + "번만에 정답입니다" );
				break;
			}else if( rand > answer ){
				System.out.println("입력한 값이 더 작습니다");
			}else{System.out.println("입력한 값이 더 큽니다");
			}

		
		}	//while
	}	//main
}	//class
