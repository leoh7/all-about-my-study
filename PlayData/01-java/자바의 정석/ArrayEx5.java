class ArrayEx5{
	public static void main(String[] args) {
	
	/*
	int kor = 81;	//국어 점수
	int eng = 75;	//영어 점수
	int mat = 91;	//수학 점수

	int sum = 0;
	double avg = 0;
	

	sum = kor + eng + mat;
	avg = sum / (double)3;

	System.out.println("국어 : " + kor);
	System.out.println("수어 : " + mat);
	System.out.println("영어 : " + eng);
	System.out.println("총점 : " + sum);
	System.out.println("평균 : " + avg);

	*/

	int sum = 0;
	double average = 0f;
	
	

	int [] score = {100, 88, 100, 100, 90};

	for (int i=0; i < score.length ; i++){
		sum += score[i];
		}
	average = sum / (double)score.length;

	System.out.println("총점 : " + sum);
	System.out.println("평균 : " + average);
	}
}
