/*
���� ���� ���� ������ ����� �μ��� �Է¹޴´�.
���� ����� ���� ��
��� 70�� �̻� "�հ�" ���
�̸� "���հ�" ���

�Է¹��� �� ���� ���� �ϳ��� 0~100 ���� ���̸�
"�߸��Է� �߽��ϴ�." ���

Hint. �μ��� �ټ� ���� �� ��ĭ ��� �ִ´�
		���׿��� �ȿ� ���׿����� �� �־ ����
*/


class  OperatorStudy {
	public static void main(String[] args) 	{
	
	int kor = Integer.parseInt( args[0] );
	int eng = Integer.parseInt( args[1] );
	int mat = Integer.parseInt( args[2] );

	int sum = 0;
	
	double avg = 0;

	sum = kor + eng + mat;
	avg = sum / 3;

		/*
	System.out.println((kor >= 0 && kor <=100) ? (avg >= 70 ? "�հ�" : "���հ�") : "�߸� �Է��ϼ̽��ϴ�");
	System.out.println((eng >= 0 && eng <=100) ? (avg >= 70 ? "�հ�" : "���հ�") : "�߸� �Է��ϼ̽��ϴ�");
	System.out.println((mat >= 0 && mat <=100) ? (avg >= 70 ? "�հ�" : "���հ�") : "�߸� �Է��ϼ̽��ϴ�");
	//	&& (eng >= 0 && eng <=100) && (mat >= 0 && mat <=100); //? (avg >= 70 ? "�հ�" : "���հ�") : System.out.println("�߸� �Է��ϼ̽��ϴ�"));
	*/

	System.out.println( ((kor >=0 && kor <=100) && (eng >= 0 && eng <=100) && (mat >= 0 && mat <=100)) ? (avg >= 70 ? "�հ�" : "���հ�") : "�߸� �Է��ϼ̽��ϴ�"  );

	}
}
