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
class WhileStudy2_3 {
	public static void main(String[] args) throws Exception{
	
		BufferedReader	br = new BufferedReader( new InputStreamReader( System.in ));	
		
	/*������ �ڵ�
	do{
		int cnt = 0, sum = 0;
		for( int i=0; i<10; i++){		//10�����ϱ� for �� 10�� ���ֱ���
		int a = (int) (Math.random()*100)+1;
		int b = (int) (Math.random()*100)+1;	//10������ �����ϱ� ������ �ݺ��� �ȿ� �����Ѵ�.
		}
		System.out.print("["+(i+1)+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = �Է°�
		int answer = Integer.parseInt( br.readLine() );	// �Է°��� �޾Ƽ� answer�� ����
												//������ ó������ �ѹ��� �� �Ϸ��� �ϸ� �ȵȴ�. �ǰ� �ִ��� ���������� Ȯ���ذ��鼭 �ؾ���
		if( a+b == answer){
			cnt++;
			sum += 10;
		} else {
		}											

		char yn = null;		//����								//yn�� �ȿ� ������ do{} �ϰ� ������ while�� �ν��� ���Ѵ�. ������ ����� ��
		char yn = '\0'		//1����Ʈ�� null �̶�� �Ҹ�
		char yn = '\u0000'	//2����Ʈ�� null �̶�� �Ҹ�
		char yn = 0			�̷��� �ص� ��, ������ char�� ���� ���� �� ���ϱ�

		System.out.print("���Ұų�");
		yn = (char) System.in.read();	//���� �빮�ڿ� �ҹ��� ���и� �ϸ� ��
		System.in.read();
		System.in.read();

	}while(yn == "Y" || yn == "y");
	*/

	outer:
		while(true){			//���� Ǯ��
			
			int queNum = 0;

			for(int i=1 ;; i++){
				if(i == 11)break;	
				int a = (int)(Math.random() * 100) + 1;				// Math.random() �� 0.999999999~ ���� ������ ������ �Ǵµ� 1.0�� ������ �ȵ�/ �׷��� int ����ȯ�� (*100) �� �ص� 0~99 ������ ������ �Ǵ°� / �Ͽ� + 1�� ���ش� / ���࿡ 1~45������ ������ �߻���Ű�� �ʹ�? / �׷� *45�� ���ϰ� �ڿ� +1 �ϸ� �Ǵ� �� 
				int b = (int)(Math.random() * 100) + 1;

				int plusValue = a + b;

				System.out.print("["+i+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = �Է°�
				
				
				int answer = Integer.parseInt( br.readLine() );			//����� �Է�
				
				if(plusValue == answer){								//���࿡ plusValue �� answer
					queNum++;											//���� ��ȣ +1
					System.out.println("�¾ҽ��ϴ� "+"\n"+"���� ���� ����:"+queNum);
					System.out.println("");
					
				}else{
					System.out.println("Ʋ�Ƚ��ϴ�");
					System.out.println("���� : " + plusValue);
					System.out.println("");
				}

			}System.out.println("�� ���� ���� : " + queNum);

			question :
			for(;;){
				
				System.out.println("�� �Ͻðڽ��ϱ�? Y(y) or N(n)");
				String yN = br.readLine();
				switch(yN){
					case "Y": break question;
					case "y": break question;
					case "N": break outer;
					case "n": break outer;
					default : System.out.println("Y(y) or N(n) ���� �Է��ϼ���");

				}
			}




		//	for(;queNum==10;){			//�� �Ұų� ���ų� case?
		//	}
		}
		//System.out.println("�����ϼ̽��ϴ�");

		
	}
}
