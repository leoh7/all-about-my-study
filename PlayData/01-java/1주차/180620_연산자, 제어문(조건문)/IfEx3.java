/*

	제어문	조건문
			-if( 조건 ) 참;
			-if( 조건 ) 참;
			else 거짓;
			-if( 조건 ) 참;
			else if( 조건 ) 참;
			...
			else 거짓;
			-switch ~ case

			반복문
			-for
			-while
			-do ~ while

*/

class IfEx3 {

	//입력받은 값이 2~9 사이면 "정상"
	// 아니면 "비정상"

	public static void main(String[] args) {
		
		int a = Integer.parseInt( args[0]);

		if( a >= 2 && a <= 9 ){
			System.out.println("정상");
		}else{
			System.out.println("비정상");
		}

	}
}
