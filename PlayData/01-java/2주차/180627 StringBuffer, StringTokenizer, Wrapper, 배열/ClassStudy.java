/*
�� ������ ������ Ǫ����.
���� ���� ��� Ŭ���� ������ �ڼ�� Ǯ��� �մϴ�.
�ҽ� �ִ������� ���̼���
�����ϰ� �ϸ� �ȵǰ� ������ �Է� �𸣴ϱ�
������ �Է¹޾Ҵٰ� �����ϰ� ���� ��

�̰� �������� �ִٴ� ���� ���� �� ���ƿ����ϱ� ������ ����
��Ʈ�� z�� ������ �ִٰ� �ص� �� �̻� ������ �ʾƵ� �ȴٴ� �Ҹ��Դϴ�.
�׸� ���ư����� �����ϱ� �����͵� ���ư�������
*/

class  ClassStudy {
	//��� ���� = �ν��Ͻ� ����
	private int valueA, valueB, valueC, sum;
	private double avg;

	//������
	public ClassStudy() {		//default ������					//Ư�� ���� �������� �ʱ�ȭ �ϱ� ���� ��¿ �� ���� �ʿ��� ������ �����ε�
		this(0, 0, 0);			//�׳� �ٿ���	//�⺻ ���� �Ʒ� �����ڸ� �����Ͽ� (0, 0, 0) ���� �ʱ�ȭ�Ѵ�
	}			
	
	public ClassStudy(int valueA, int valueB, int valueC){		//Ư�� ���� �������� �ʱ�ȭ �ϱ� ���� ��¿ �� ���� �ʿ��� ������ �����ε�
		this.valueA = valueA;			//this.������� = �Ű����� / this �ȿ� �ִ� ���������, �Ű������� �����ض�
		this.valueB = valueB;
		this.valueC = valueC;
	}

	//��� �޼��� = �ν��Ͻ� �޼��� 
	public int total() {				//������ �Ű������� ���� ���?
		sum = valueA + valueB + valueC;
		return sum;
	}
	public double average() {
		avg = (double)sum / 3;
		return avg;
	}
	public String pass() {
		if(avg >= 70) {
			return "�հ�";
		}else{				//else�� ���ٸ�? if(avg >= 70){��: return "�հ�" }{����: return "���հ�"} 
			return "���հ�";
		}
	}



	public static void main(String[] args) {

		ClassStudy cs = new ClassStudy( 47, 55, 91);
//		System.out.println("value A ="+cs.valueA +"\t"+"value B ="+ cs.valueB +"\t"+"value C ="+ cs.valueC);		// test �� �ڵ�
		
		System.out.println( "���� : " + cs.total() );
		System.out.printf( "��� : %.2f\n", cs.average() );
		System.out.println( "��� : " + cs.pass() );	// 70�� �̻��̸� "�հ�"
			if(true){System.out.println("��");}
			else if	{System.out.println("����");}
	}	//main

}	//class


/*
���� : 193
��� : 64.33
��� : ���հ�
*/