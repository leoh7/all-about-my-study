/*
�޼���� �Ѱ��� ���� / �Ϻ��ϰ� �ϰԲ� ��������� ����?
��ɾ �������� �ϰ� ����� �������� �ϴ°� �� �ϳ� �ۿ� ����
�Ѱ����� �ϰԲ� ���ָ� �������� ���� ���� ���� �� �ֱ� ����. ������ �� ����.

return
return ���� �� �� ���̴�.
*/

class MethodEx5 {
	/*
	public void hap (int a, int b){				//���� + ��� �� ���� ���� �ϰ� �ִ�.	//������ �ϰ� ������? �̰� �� ���ٴ� �Ҹ�
		System.out.println("���� : "+ (a+b) );
	}
	*/
	// void�� // �����, ��ȯ�� �ڸ� // void�� �׳� ���ƿ� ���� return�� �����ص� ��. // ���� ������ ���ƿ� ���� return�� ����� �ǰ�

	public int hap (int a, int b){
		return a+b;		//�Ű������� �Ѿ�� �����͸� ���� ����� ���� ����		// ����������� ��� //�ڱ� ȥ�ڹۿ� �� ���� ���� // ���ؼ� ���� ���� �׷�? �ȿ��� �ۿ� ������
	}					//�׷��� return;
	public int cha (int a, int b){
		return a-b;
	}
	public int gop (int a, int b){
		return a*b;
	}
	public double mok (int a, int b){
		return (double) a/b;
	}
	//	public double mok (double a, double b){
	//		return a/b;
	//	}


	public static void main(String[] args){

		MethodEx5 me = new MethodEx5();
		int sum = me.hap(5,2);
		System.out.println("���� : " + sum);
		System.out.println("System.out.println(��ȿ���) ȣ���� �� ���� �ִ� : "+me.hap(5,2));	//return ���� ������ ������ ���ܴ�. return ���� ���°� println �� ���� ������
		System.out.println("�� : "+me.cha(5,2));
		System.out.println("�� : "+me.gop(5,2));
		System.out.println("�� : "+me.mok(5,2));
		//System.out.println("�� : "+me.mok(5,2));

	}
}