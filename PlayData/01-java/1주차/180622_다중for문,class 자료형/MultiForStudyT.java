/*
for i �� �ǵ��� ������ ������ �� ������ ���ϱ�
*/

class MultiForStudyT {
	public static void main(String[] args) {
		
//1�� ����
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("*");
			}	//for i 
		System.out.println("");	//�� �ٲ�
		}		//for j
//1�� ��
	System.out.println("1���� �����ϴ�");

//2�� ����

		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<4-i ; j++ ){
				System.out.print(" ");
			}
			
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("*");
			}	//for i 
		System.out.println(" ");	//�� �ٲ�
		}		//for j
		
		for( int i=0 ; i<5 ; i++ ){
			for( int j=0 ; j<=4-i ; j++ ){
				System.out.print("0");
			}	
			
			for( int j=0 ; j<=i ; j++ ){
				System.out.print("1");
			}	

//2�� ��
	}
}