

class MultiForEx3{
	public static void main(String[] args) 	{
		for(int i=2; i<10 ; i++ ){
			System.out.print(i + "��\t" );
		}
			System.out.print("\n");

		for(int i=1 ; i<10 ; i++ ){		
			
			for( int j=2 ; j<10 ; j++ ){	
			
			System.out.print(j + "*" + i + "=" + (i*j) + "\t" );		//� ���ڰ� ��� �ٲ������ �ָ��ϱ�
			
			}	//for j	���� ��	
		System.out.print("\n");
		}	//for i		
		

	
	}	//main
}	//class