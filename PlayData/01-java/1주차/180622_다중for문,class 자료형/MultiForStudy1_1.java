class MultiForStudy1_1 {
	public static void main(String[] args) {
		for( int i=0 ; i<5 ; i++ ){
			for(int j=0 ; j<=i ; j++ ){
				System.out.print("1");
			}
			for(int j=0 ; j<=4-i ; j++ ){
				System.out.print("0");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("1¹øÀÌ ³¡³³´Ï´Ù");
		System.out.println("");

		for( int i=0 ; i<5 ; i++ ){
			for( int j=0; j<=4-i ; j++ ){
			System.out.print("0");
			}
			for( int j=0 ; j<=i ; j++ ){
			System.out.print("1");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("2¹øÀÌ ³¡³³´Ï´Ù");
		System.out.println("");

		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=4-i ; j++ ){
				System.out.print("1");
			}
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("0");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("3¹øÀÌ ³¡³³´Ï´Ù");
		System.out.println("");
		
		for( int i=0 ; i<5 ; i++ ){

			for( int j=0 ; j<=i ; j++ ){
				System.out.print("0");
			}
			for( int j=0 ; j<=4-i ; j++ ){
				System.out.print("1");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("4¹øÀÌ ³¡³³´Ï´Ù");
		System.out.println("");

		for( int i=0; i<5 ; i++ ){
			for( int j=0; j<=4-i ; j++){
				System.out.print("0");
			}

			for( int j=1; j<=(i+1)*2 ; j++ )
				System.out.print("1");
			
			for( int j=0; j<=4-i ; j++){
				System.out.print("0");
			}
			System.out.println("");
		}
		for( int i=0; i<5 ; i++ ){
			for( int j=0; j<=i ; j++){
				System.out.print("0");
			}

			for( int j=1; j<=(5-i)*2 ; j++ )
				System.out.print("1");
			
			for( int j=0; j<=i ; j++){
				System.out.print("0");
			}
			System.out.println("");
		}

		System.out.println("");
		System.out.println("¼÷Á¦°¡ ³¡³³´Ï´Ù!");
		System.out.println("");

		for( int i=0; i<5 ; i++ ){
			for( int j=0; j<=4-i ; j++){
				System.out.print(" ");
			}

			for( int j=1; j<=(i+1)*2 ; j++ )
				System.out.print("*");
			
			for( int j=0; j<=4-i ; j++){
				System.out.print(" ");
			}
			System.out.println("");
		}
		for( int i=0; i<5 ; i++ ){
			for( int j=0; j<=i ; j++){
				System.out.print(" ");
			}

			for( int j=1; j<=(5-i)*2 ; j++ )
				System.out.print("*");
			
			for( int j=0; j<=i ; j++){
				System.out.print(" ");
			}
			System.out.println("");
		}

		System.out.println("");
		System.out.println("¼÷Á¦°¡ ³¡³³´Ï´Ù!!!!!!!!!!!!!!!");
		System.out.println("");

/*
¼±»ý´Ô Ç®ÀÌ
		for( int i=0; i<5 ; i++ ){
			for( int j=0; j<=i ; j++){
				System.out.print(" ");
			}

			for( int j=0 ; j<=4-i ; j++ ){
				System.out.print("*");
			}
			
			for( int j=0; j<=i ; j++){
				System.out.print(" ");
			}
			System.out.println("");
		}
*/
/*
							0123456789ab	//ÃÑ 12ÁÙ
		System.out.println("000001100000")	//2
		System.out.println("000011110000")	//4
		System.out.println("000111111000")	//6
		System.out.println("001111111100")	//8
		System.out.println("011111111110")	//10

		System.out.println("011111111110")	//5 + 5	//5 * 2		//y = (5-x) * 2
		System.out.println("001111111100")	//4 + 4	//4 * 2
		System.out.println("000111111000")	//3 + 3	//3 * 2
		System.out.println("000011110000")	//2 + 2	//2 * 2
		System.out.println("000001100000")	//1 + 1	//1 * 2

*/
	}	//main
}	//class
