class MultiForEx1{
	public static void main(String[] args) 	{

		for( int i=0; i<3 ; i+=2 ){			// 0 2		//증감값을 i+=2 이렇게 주는 것도 있었단걸 기억하자, 이렇게 주면 어떤다? 자동으로 형변환이 일어난다.
			for( int j=0 ; j<3 ; j++ ){		// 0 1 2
				System.out.println("i : " + i + "\t" + "j : " + j );
			}
		}	//for j
	}	//for i
}

/*

i값이 한번 돌 때
j값이 3번을 돈다	for( int j=0 ; j<3 ; j++ )
*/
