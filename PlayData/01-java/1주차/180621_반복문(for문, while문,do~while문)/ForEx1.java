/*
	세미콜로 찍어서 구분하는건 for문 밖에 없을꺼야
	그 이유는 각각 실행문이라는 것.

		int i 가 안에 있는 이유(지역변수)			//cf) <-> 전역변수
		c에서는 밖에다 초기화하고 안에다가 i = 0 이라고만 해도 되는데(메모리 관리가 가능해서)
		자바는 메모리 관리를 건드리지 않으니까 안에다 둘 것

	for문은 참일 때 돌고 거짓이면 빠져나온다

for( int i = 0; i<3; i++ ) {
 //( 초기값(처음만); 조건; 증감값)
//	   1번 실행 ; 2번 참; 그 다음 i++4번			//복습과제 -> 진행과정 순서에 따라 한줄씩 정리해보자
//				아래 실행 3번
System.out.println( "i : " + i );

			//복습과제 완성
			int i = 0;								//초기화
			if(i<3){
				System.out.println( "i : " + i );	//i : 0 출력
				i += 1;}
					
			if(i<3){
				System.out.println( "i : " + i );	//i : 1 출력
				i += 1;}
				
			if(i<3){
				System.out.println( "i : " + i );	//i : 2 출력
				}




*/


class ForEx1 {
	public static void main(String[] args) {


		//for( int i = 0; i<3; i++ ) {
		// 초기값 ; 조건; 증감값
//			System.out.println( "i : " + i );


		//for( int i = 1; i<=10; i++ ){			//보통은 int i = 0 으로 i<11 으로 쓴다


		//for( int i = 10; i>0; i-- ){			
		//	for( int i = 0; i<11; i+=2 ){		//2 4 6 8 10
		//	System.out.println( "i : " + i );

			//복습과제 완성


			int i = 0;								//초기화
			if(i<3){
				System.out.println( "i : " + i );	//i : 0 출력
				i += 1;}
					
			if(i<3){
				System.out.println( "i : " + i );	//i : 1 출력
				i += 1;}
				
			if(i<3){
				System.out.println( "i : " + i );	//i : 2 출력
				}
		
	}	//main
}		//class

