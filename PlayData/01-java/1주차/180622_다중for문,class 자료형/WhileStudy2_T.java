/*WhileStudy2
1~100������ ������ 2�� �߻��Ͽ� ������ ���ߴ� ����
10������ Ǯ��
[1]	ran1 + ran2 = �Է°�
[1] 25+ 36 = 100	//25, 36 ���� / 100 �Է� ��
Ʋ�ȴ�...
���� : 61

[2] 50 + 36 = 86
�¾Ҵ�
...

//[10] ���� ��
���� ���� : XX��
���� : XX��

������ �� Ǯ���� ���´�.
'Y' �Ǵ� 'y' �ԷµǸ� �ٽ� 10������ �����Ѵ�.
'N' �Ǵ� 'n' �ԷµǸ� ���α׷� ����


���±��� ���� �ý�.������ �Է°��� ���� ���� �ϳ��� �����ϱ�
�׷��� IO ���ܰ� �ϳ� ������


���� 10�� �ݺ��� �ϳ�
���� �ðų� ���ų� �ݺ��� �ϳ�
*/

import java.io.BufferedReader;		//import�� . �� ������ �ǹ�	//���߿� 2,30�� �ɰ���
import java.io.InputStreamReader;
class WhileStudy2_T {
	public static void main(String[] args) throws Exception{
	
		BufferedReader	br = new BufferedReader( new InputStreamReader( System.in ));	
		char yn = 0;
	//	char yn = null;			//����								//yn�� �ȿ� ������ do{} �ϰ� ������ while�� �ν��� ���Ѵ�. ������ ����� ��
	//	char yn = '\0';			//1����Ʈ�� null �̶�� �Ҹ�
	//	char yn = '\u0000';		//2����Ʈ�� null �̶�� �Ҹ�
	//	char yn = 0;			//�̷��� �ص� ��, ������ char�� ���� ���� �� ���ϱ�


	do{
		int cnt = 0;
		int sum = 0;
		
		
		for( int i=0; i<10; i++){				//10�����ϱ� for �� 10�� ���ֱ���
			int a = (int) (Math.random()*100)+1;
			int b = (int) (Math.random()*100)+1;	//10������ �����ϱ� ������ �ݺ��� �ȿ� �����Ѵ�.
			
			
			System.out.print("["+(i+1)+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = �Է°�
			
			int answer = Integer.parseInt( br.readLine() );	// �Է°��� �޾Ƽ� answer�� ����
			
			
			if( a+b == answer){			//��
				cnt++;
				sum += 10;
			} else {				//����
			}											
		}	// for i

		System.out.println("���� ���� : "+ cnt);
		System.out.print("���Ұų� Y or N");
		yn = (char) System.in.read();	//���� �빮�ڿ� �ҹ��� ���и� �ϸ� ��
		System.in.read();
		System.in.read();

	}while(yn == 'Y' || yn == 'y');





		}	// main

		
	}	// class

