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

class IfEx1 {
/*

if esle 를 한 쌍으로 쓰는 것
else if 를 여러 쌍으로 쓰는 것


*/


	public static void main(String[] args) {
		int a = Integer.parseInt( args[0]);

		if( a > 5) {
			System.out.println("크다");		// 참
		} else {
			System.out.println("작다");		// 거짓

		}
	
	
	}
}
