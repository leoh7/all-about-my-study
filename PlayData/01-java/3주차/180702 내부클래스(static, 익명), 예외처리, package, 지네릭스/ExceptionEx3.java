// User Exception	����� ���� ����
// �������� �Է¹޾� ���
// �� 2 ~ 9 ���� ���� ���ܷ� ó��
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UserException extends Exception{	// ��Ӹ� ������ ���� Ŭ������ �ȴ�!

}

class ExceptionEx3 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		int dan = 0;
		
		try{
				System.out.print("�� �Է� : ");
				dan = Integer.parseInt(br.readLine() );
				if(dan<2 || dan>9){
					throw new UserException();		// ���µ� ������ ������ ������	// throw �ڿ� ���� Ŭ������ ��� �Ǵµ� UserException �� ���� Ŭ������ �ƴϴ�? ���ܿ� ������ ������ Exception �� ��ӹ޴´� / 
			} else {
				// ������ ���
			}
		} catch( IOException e ){
			e.printStackTrace();
		} catch( UserException e ){
			System.out.println("2~9���̸� �Է��ϼ���");
		}

	}
}
/*
�������� �翬�� 2~9 �� �Է��Ҳ���, ������ �ޱ�� �����ϱ� 100�� �޵� 1000�� �޵� ������ �Ƴ�.
�������� ��ڴٰ� �ϴϱ� ������, ���α׷� ������ ���ݵ��� ����.
�׷��� ������ ���ܸ� ���� ���� ����ó���� ����� ���ž�
�����α׷� �� �� ���� ������

	�߿��Ѱ� throws ��� ���� ��µ�, ������ �� �� throw �� ����.

*/