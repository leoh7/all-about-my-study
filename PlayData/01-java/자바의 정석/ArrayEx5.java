class ArrayEx5{
	public static void main(String[] args) {
	
	/*
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

	*/

	int sum = 0;
	double average = 0f;
	
	

	int [] score = {100, 88, 100, 100, 90};

	for (int i=0; i < score.length ; i++){
		sum += score[i];
		}
	average = sum / (double)score.length;

	System.out.println("���� : " + sum);
	System.out.println("��� : " + average);
	}
}
