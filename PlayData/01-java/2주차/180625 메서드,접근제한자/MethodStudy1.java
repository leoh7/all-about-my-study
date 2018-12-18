//오버로드
class MethodStudy1 {

	public void disp( char a, int x){
		
		System.out.print(x+"\t");	//"3	"을 출력
		for(int i=0;i<x;i++){
			System.out.print(a);	//char 값 a를 int x번 반복 출력한다.
		}
	System.out.println("");
	}
	
	public void disp( int x, int y, char a){
		int p = x - y;
		System.out.print(p+"\t");	//"9-5	"을 출력
		for(int i=0;i<p;i++){
			System.out.print(a);	//a를 int p번 반복 출력한다.
		}
	System.out.println("");
	}

	public void disp( char a, char b, int x){
		System.out.print(x+"\t");	//"7	"을 출력
		
		for( int i=0 ; i<x ; i++ ){
			if(x % 2 == 0){
				System.out.print(a);
			}else{
				System.out.print(b);
			}
		}

		/*							
		for(int i=0; i<x ;i++){		
			if(x % 2 == 0){				//x가 짝수일 때,
										
				int tmp = (x+1) - i;	//x가 홀수일 때
				switch(tmp % 2){
					case 1 : System.out.print(a);break;
					case 0 : System.out.print(b);break;}
				}else{
				int tmp = x - i;	//x가 홀수일 때
				switch(tmp % 2){
					case 1 : System.out.print(a);break;
					case 0 : System.out.print(b);break;}
			}

		} */
		System.out.println("");
	}


	public static void main(String [] args) {
		MethodStudy1 ms = new MethodStudy1();
		ms.disp( '@', 3 );			// 3	@@@
		ms.disp( '#', 5 );			// 5	#####
		ms.disp( '%', 7 );			// 7	%%%%%%%
		ms.disp( 9, 5, '&' );		// 4	&&&&
		ms.disp( '@', '#' , 7 );	// 7	@#@#@#@



	
	}	//main
}	//class