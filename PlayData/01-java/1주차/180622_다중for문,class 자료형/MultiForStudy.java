//4���� �� ���´ٴ°� ��Ʈ
class MultiForStudy {
	public static void main(String[] args) {
		
//1�� ����
		for( int i=0 ; i<5 ; i++){


			for( int j=0 ; j<=i; j++ ){
				System.out.print("1");
			}
			for( int j=0 ; j<=4-i; j++ ){
				System.out.print("0");
			}
		System.out.println("");	//�� �ٲ�

		}
//1�� ��
	System.out.println("1���� �����ϴ�");

//2�� ����
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<4-i ; j++ ){
				System.out.print("0");
			}	
			
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("1");
			}	
		System.out.println("");	//�� �ٲ�
		}		//for //2�� ��
//2�� ��
	System.out.println("2���� �����ϴ�");



//3�� ����


		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=4-i ; j++ ){
				System.out.print("1");
			}	//for i
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("0");
			}	//for i 
		System.out.println("");	//�� �ٲ�
		}		//for j
//3�� ��

//4�� ����
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=i ; j++ ){
				System.out.println("0");
			}
			for( int j=0; i<=4-i ; j++ ){		// 1�� �Ųٷγ�???
				System.out.println("1");
			}
			
		}

//4�� ��


	}	//main
}	//class







/*
     01234 01234 
��  0 00001 10000 ��	
   1 00011 11000
   2 00111 11100
   3 01111 11110
   4 11111 11111

     01234 01234
   0 11111 11111
   1 01111 11110
   2 00111 11100
   3 00011 11000
��  4 00001 10000  ��
*/
/*
	�� �� �� ����� ���ļ� �Ʒ� ����� �����.
  
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
�̰� ���
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