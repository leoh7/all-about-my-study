

class MultiForEx3{
	public static void main(String[] args) 	{
		for(int i=2; i<10 ; i++ ){
			System.out.print(i + "단\t" );
		}
			System.out.print("\n");

		for(int i=1 ; i<10 ; i++ ){		
			
			for( int j=2 ; j<10 ; j++ ){	
			
			System.out.print(j + "*" + i + "=" + (i*j) + "\t" );		//어떤 숫자가 계속 바뀌는지를 주목하기
			
			}	//for j	세로 줄	
		System.out.print("\n");
		}	//for i		
		

	
	}	//main
}	//class