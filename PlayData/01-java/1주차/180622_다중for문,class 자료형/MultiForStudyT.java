/*
for i 는 건들지 마세요 숙제할 때 좆같아 지니까
*/

class MultiForStudyT {
	public static void main(String[] args) {
		
//1번 시작
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("*");
			}	//for i 
		System.out.println("");	//행 바꿈
		}		//for j
//1번 끝
	System.out.println("1번이 끝납니다");

//2번 시작

		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<4-i ; j++ ){
				System.out.print(" ");
			}
			
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("*");
			}	//for i 
		System.out.println(" ");	//행 바꿈
		}		//for j
		
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=4-i ; j++ ){
				System.out.print("0");
			}	
			
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("1");
			}	

//2번 끝
	}
}