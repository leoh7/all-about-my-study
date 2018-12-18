class VariableStudy{
	public static void main(String[] args) {
		
	/*
	숙제는 질문하지 마세요
	국어 : 81점
	영어 : 75점
	수학 : 91점
	총점 : ---점
	평균 : --.-점
	
	총점과 평균을 구하기
	*/
	
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

	}
}
