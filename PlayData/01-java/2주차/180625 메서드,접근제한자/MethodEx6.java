//���� �� ���� �Է¹޾Ƽ� ���� ū �� �ϳ��� ���

import java.io.BufferedReader;
import java.io.InputStreamReader;

class MethodEx6{
	
	public int big(int a, int b, int c){
		if(a > b && a > c) return a;
		else if(b > c) return b;
		else return c;		//�������� �� �̰ɷ� �Ѵ�, ��� ���� �ʿ��ϴ�. ������ �ָ� �ȵ�

		//System.out.println(" ");	//return �ؿ��� �� �൵ ������ ����!
	}
	
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	
	System.out.print("���� 1 : ");
	int a = Integer.parseInt(br.readLine() );

	System.out.print("���� 2 : ");
	int b = Integer.parseInt(br.readLine() );

	System.out.print("���� 3 : ");
	int c = Integer.parseInt(br.readLine() );
	
	MethodEx6 me = new MethodEx6();
	System.out.println("���� ū ���� "+ me.big(a,b,c) );

		for(int i=0;i<=20;i++){
		i =	me.big(a,b,c);
		}
	}	//main
}	//class