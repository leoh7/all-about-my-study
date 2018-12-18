class FlowEx33 {
	public static void main(String[] args) {
		//for문에 Loop1이라는 이름을 붙였다.
		Loop1 : for( int i=2 ; i<=9 ; i++ ){		//구구단을 할거다
					for( int j=1; j<=9 ; j++ ){
						if(j==5)
						break Loop1;	//j가 5일 때 Loop1 이라 이름 붙여진 반복문을 탈출한다.
					//	break;			//for j 만 탈출, 결과적으로 2단부터 9단까지 1,2,3,4 곱한 값만 도출된다.
					//	continue Loop1;	//아래 어딨나요가 실행이 되지 않는다? / 책이 쓸 일 없대니깐 무시하자
					//	continue;
					System.out.println(i+"*"+j+"="+ i*j);

					}	//end of for i
		System.out.println("어딨나요");
		}	//end of Loop1

	}
}
