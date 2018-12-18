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

class MethodStudy2 {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
	
	private int tmp;
	private int dan;
	
	
	public int input( ) throws Exception{
		while(true){
			System.out.print("2~9 �� �Ѱ� ���� :");
			tmp = Integer.parseInt(br.readLine() );

			if(tmp < 10 && tmp > 1){
				System.out.println("input �޼����� �Ű������� �Է°� "+tmp+" �� �޾ҽ��ϴ�");
				dan = tmp;
				break;
				
			}else{ System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.(2~9�� �ش��ϴ� ���� �Է�)"); }
		
		}return dan;
	}	// int input ��

	public void output(int x) {
			x = dan;
		for(int i=1; i<10 ;i++){
			
			System.out.println(x+" * "+i+" = "+(x*i));
		}
		System.out.println("");
	}	//void output ��
	
	
		
		
		//�� ������ main �޼���

	public static void main(String [] args) throws Exception {
		MethodStudy2 m2 = new MethodStudy2();
		while(true){m2.output( m2.input() );}
	}	//main
	
}	//class