
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


//WhileStudy �� �����ϱ� ���� ����
import java.io.BufferedReader;		//import�� . �� ������ �ǹ�	//���߿� 2,30�� �ɰ���
import java.io.InputStreamReader;


class  WhileStudy2{
/*
Ŭ������	WhileStudy2

�Ӽ�		plusValue		������ ���� ���
		queNum			���� ���� ��ȣ

����		setPlusValue	������ ���� �����Ѵ�.			/ int x, y / x + y
		getPlusValue	������ ���� �����´�.
		
		queNumZ			���� ��ȣ�� �ʱ�ȭ ��Ų��. �ʱⰪ = 1
		queNumPlus		���� ������ �����Ų��.
		queNumCheck			10�� �����ΰ�?

*/
	int plusValue;
	int queNum;

	
	void setPlusValue(int x, int y){
		plusValue = x + y;
	}
	int getPlusValue(int x){
		return x;
	}

	void queNumZ(int x){
		queNum = 1;
	}	
	void queNumPlus(int x){
		queNum += 1;
	} 
	boolean queNumCheck(){
		if(queNum == 10)
			return true; 
				return false;
	}
	void getQuestion(int x, int y){
			System.out.println(" ["+queNum+"] " + a +" "+ b + " = " +answer);			//[queNum]	ran1 + ran2 = �Է°�
		}
	


		
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader	br 
			= new BufferedReader( new InputStreamReader( System.in ));					//�Է� ���۸� �о���� Ŭ���� / ���� ���� ��Ű���� �޶� / ����� ���� ��Ű���� ��μ����� �ؾ���
																							// java.lang ��Ű��(����) / Ư¡�� ���� ���� ���� Ŭ������ ��Ƴ��� / �׷��� ���� ���� ���ϱ� ���� ��Ƴ��� ���� �Ȱ����͵� ��
		int a = (int)(Math.random() * 100) + 1;				// Math.random() �� 0.999999999~ ���� ������ ������ �Ǵµ� 1.0�� ������ �ȵ�/ �׷��� int ����ȯ�� (*100) �� �ص� 0~99 ������ ������ �Ǵ°� / �Ͽ� + 1�� ���ش� / ���࿡ 1~45������ ������ �߻���Ű�� �ʹ�? / �׷� *45�� ���ϰ� �ڿ� +1 �ϸ� �Ǵ� �� 
		int b = (int)(Math.random() * 100) + 1;

		int answer = Integer.parseInt( br.readLine() );				//int a = br.readLine(); �̷��� �ϸ� ����. �갡 �� ���ٷ� (���ͱ��� ���ٷ�) �ν���. �׸��� �����ִ� ���� ���ڿ��̾�	
		char yesOrNo = Character.parseChar( br.readLine() );


	do{

/*
Ŭ������	WhileStudy2

�Ӽ�		plusValue		������ ���� ���
		queNum			���� ���� ��ȣ

����		setPlusValue	������ ���� �����Ѵ�.			/ int x, y / x + y
		getPlusValue	������ ���� �����´�.
		
		queNumZ			���� ��ȣ�� �ʱ�ȭ ��Ų��. �ʱⰪ = 1
		queNumPlus		���� ������ 1 �����Ų��.
		queNumCheck			10�� �����ΰ�?

*/
		for( ;queNum == 10 ; ){
		
		
		}
			
		
	}while(yesOrNo == ('Y' || 'y') );	//�Է°��� Y,y �� ��� ���� �ٽ��ϱ�

	
	
	}	//main
}		//class


/*


*/