/*
****** �̰� ���迡 ���ϴ� ******
���۵� ������ ��������

input() �޼��忡�� ������ �Է¹޾Ƽ�
output() �޼��忡�� �������� ����Ѵ�.
2~9 ������ ���� �ƴϸ� �ٽ� �Է� �޴´�.
��, input() �޼��忡�� �Է��� �ްԵǸ� ���ܰ� �߻��ϱ� ������
throws Exception �� ����� �Ѵ�.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class MethodStudy2_T {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		
		int dan = 0;
	
		
		public int input( ) throws Exception{
		do{
			System.out.print("�� �Է� :");
			dan = Integer.parseInt(br.readLine());
		}while( dan<2 || dan>9 );
		return dan;
		}	// int input ��

	

		

	public void output(int dan) {
		for( int i=1; i<10; i++){
			System.out.println( dan + "*" + i + " = " + dan*i );
		}
		
	}	//void output ��
	
	
		
		
		//�� ������ main �޼���

	public static void main(String [] args) throws Exception {
		MethodStudy2_T m2 = new MethodStudy2_T();
		while(true){ m2.output( m2.input() ); }
	
	}	//main
	
}	//class