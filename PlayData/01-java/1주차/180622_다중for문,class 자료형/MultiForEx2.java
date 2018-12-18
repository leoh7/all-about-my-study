/*
2단		//시작할 때 단 수 말하기
2 * 1 = 2
2 * 2 = 4
쭉
쭉
쭉
		//띄어쓰기
3단
*/


class MultiForEx2{
	public static void main(String[] args) 	{

		for(int i=2 ; i<10 ; i++ ){		//단 (이것도 처음 설계할 때부터 주석을 달고 하면 편해지겠다)
			System.out.println(i + "단");
			
			for( int j=1 ; j<10 ; j++ ){	//곱해지는 수 (이것도 처음 설계할 때부터 주석을 달고 하면 편해지겠다)
			System.out.println(i + " * " + j + " = " + (i*j) );
			
			}	//for j		이건 설계단계에서 단 주석
		System.out.println("\n");
		}	//for i		이건 설계단계에서 단 주석
		

	
	}	//main
}	//class

