
//int sum=0;	/ C������ class �ۿ� ���������� �����ϰ� �� �־��� / �Դٰ� �׻� static ���� ������ ��.
class MethodEx2{
	int sum=0;		//������ ���ϸ� �ڹٿ��� ���������� ����. / class �ۿ��� ������ ������ �� ���� ������ / ���� ū �����ȿ� �ִ°� �ڹٿ����� �������� ��� �ϴ� ��. / �̰��� ��� ����./ ��� ��������� ���������̴�.(�ڹٿ�����) / heap �� ���� ��

	
	public void hap(){
		int sum = 0;		// ���� ���� / gop() ���� int sum �� �����ص� ������ ���� �ʴ´�.
		for(int i=0; i<10 ;i++ ){ 
			sum += i + 1;
		}System.out.println("1~10�� ���� = " + sum);
	}
	public void gop(){
		int sum = 1;			// ���� ����
		for(int i=0; i<10 ;i++ ){ 
			sum *= i+1;
			System.out.println("������Ȳ ����: " + sum);
		}System.out.println("1~10�� ���� = " + sum);
	}
	
	
	public static void main (String [] args){
		MethodEx2 me = new MethodEx2();
		me.hap();	// 1 ~ 10���� ���� ���	��: 55			//������ ���ϴ� �޼���, ����ϴ� �޼��� �̷��� �� ������ �����°� ����. �Ѱ��� ����/�Ϻ��ϰ�
		me.gop();	// 1 ~ 10���� ���� ���	��: 3628800
	}	//main
}	//class