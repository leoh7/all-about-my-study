//4개를 잘 섞는다는게 힌트
class MultiForStudy {
	public static void main(String[] args) {
		
//1번 시작
		for( int i=0 ; i<5 ; i++){


			for( int j=0 ; j<=i; j++ ){
				System.out.print("1");
			}
			for( int j=0 ; j<=4-i; j++ ){
				System.out.print("0");
			}
		System.out.println("");	//행 바꿈

		}
//1번 끝
	System.out.println("1번이 끝납니다");

//2번 시작
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<4-i ; j++ ){
				System.out.print("0");
			}	
			
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("1");
			}	
		System.out.println("");	//행 바꿈
		}		//for //2번 끝
//2번 끝
	System.out.println("2번이 끝납니다");



//3번 시작


		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=4-i ; j++ ){
				System.out.print("1");
			}	//for i
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("0");
			}	//for i 
		System.out.println("");	//행 바꿈
		}		//for j
//3번 끝

//4번 시작
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=i ; j++ ){
				System.out.println("0");
			}
			for( int j=0; i<=4-i ; j++ ){		// 1번 거꾸로네???
				System.out.println("1");
			}
			
		}

//4번 끝


	}	//main
}	//class







/*
     01234 01234 
②  0 00001 10000 ①	
   1 00011 11000
   2 00111 11100
   3 01111 11110
   4 11111 11111

     01234 01234
   0 11111 11111
   1 01111 11110
   2 00111 11100
   3 00011 11000
④  4 00001 10000  ③
*/
/*
	① ② ③ ④번을 합쳐서 아래 모양을 만든다.
  
         **	
   		****
       ******
      ********
     **********
     **********
      ********
       ******
        ****
         **
이건 사실
0000110000
0001111000
0011111100
0111111110
1111111111
1111111111
0111111110
0011111100
0001111000
0000110000

*/