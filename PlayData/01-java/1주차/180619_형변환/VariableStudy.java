class VariableStudy{
	public static void main(String[] args) {
		
	/*
	������ �������� ������
	���� : 81��
	���� : 75��
	���� : 91��
	���� : ---��
	��� : --.-��
	
	������ ����� ���ϱ�
	*/
	
	int kor = 81;	//���� ����
	int eng = 75;	//���� ����
	int mat = 91;	//���� ����

	int sum = 0;
	double avg = 0;
	

	sum = kor + eng + mat;
	avg = sum / (double)3;

	System.out.println("���� : " + kor);
	System.out.println("���� : " + mat);
	System.out.println("���� : " + eng);
	System.out.println("���� : " + sum);
	System.out.println("��� : " + avg);

	}
}
