

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

class WhileStudy2_2{
/*
	Ŭ������	WhileStudy2_2
�Ӽ�		String regame;
�޼���	setRegame
		getRegame
*/




	//�Ʒ����ʹ� ����κ�
	public static void main(String[] args) throws Exception{
		BufferedReader	br 
		= new BufferedReader( new InputStreamReader( System.in ));					//�Է� ���۸� �о���� Ŭ���� / ���� ���� ��Ű���� �޶� / ����� ���� ��Ű���� ��μ����� �ؾ���	
		String regame;
		//int answer = Integer.parseInt( br.readLine() );				//int a = br.readLine(); �̷��� �ϸ� ����. �갡 �� ���ٷ� (���ͱ��� ���ٷ�) �ν���. �׸��� �����ִ� ���� ���ڿ��̾�	



		Loop1 : while(true){
			int queNum = 0;

			for(int i=1 ; i<=10 ; i++){
				
				int a = (int)(Math.random() * 100) + 1;				// Math.random() �� 0.999999999~ ���� ������ ������ �Ǵµ� 1.0�� ������ �ȵ�/ �׷��� int ����ȯ�� (*100) �� �ص� 0~99 ������ ������ �Ǵ°� / �Ͽ� + 1�� ���ش� / ���࿡ 1~45������ ������ �߻���Ű�� �ʹ�? / �׷� *45�� ���ϰ� �ڿ� +1 �ϸ� �Ǵ� �� 
				int b = (int)(Math.random() * 100) + 1;
				int plusValue = a + b;
				

				System.out.print("["+i+"] " + a +" + "+ b +" = ");		//[1]	ran1 + ran2 = �Է°�
				int answer = Integer.parseInt( br.readLine() );			//����� �Է�
				
				if(plusValue == answer){								//���࿡ plusValue �� answer
					queNum++;
					System.out.println("�¾ҽ��ϴ� "+"\n"+"���� ���� ����:"+queNum);
					System.out.println("");
					
				}else{
					System.out.println("Ʋ�Ƚ��ϴ�");
					System.out.println("���� : " + plusValue);
					System.out.println("");

				}


			}
			System.out.println("�� ���� ���� : " + queNum);
			System.out.println("�� �Ͻðڽ��ϱ�? Y(y) or N(n)");
				
				

				regame = br.readLine();
				
				for(;;){

				if(regame == "N" || regame == "n"){
				System.out.println("����ϼ̽��ϴ�");
				break;
				}
				if(regame == "Y" || regame == "y")

				break Loop1;
				}else{
				System.out.println("Y(y) or N(n) ���� �Է��ϼ���");
				}

				}
		}
				

			
				/*
				if(regame == "Y" || regame == "y"){
				}else if(regame == "N" || regame == "n"){
				System.out.println("����ϼ̽��ϴ�");

				break;
				}else{
				System.out.println("Y(y) or N(n) ���� �Է��ϼ���");
				}
				*/
			
	
		}	//while
	}	//main
	//class
