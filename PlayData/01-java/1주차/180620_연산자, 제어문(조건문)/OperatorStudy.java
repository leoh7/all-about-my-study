/*
국어 영어 수학 점수를 명령줄 인수로 입력받는다.
총점 평균을 구한 후
평균 70점 이상 "합격" 출력
미만 "불합격" 출력

입력받은 세 과묵 점수 하나라도 0~100 범위 밖이면
"잘못입력 했습니다." 출력

Hint. 인수를 다수 넣을 땐 한칸 띄고 넣는다
		삼항연산 안에 삼항연산을 또 넣어서 쓴다
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
	System.out.println((kor >= 0 && kor <=100) ? (avg >= 70 ? "합격" : "불합격") : "잘못 입력하셨습니다");
	System.out.println((eng >= 0 && eng <=100) ? (avg >= 70 ? "합격" : "불합격") : "잘못 입력하셨습니다");
	System.out.println((mat >= 0 && mat <=100) ? (avg >= 70 ? "합격" : "불합격") : "잘못 입력하셨습니다");
	//	&& (eng >= 0 && eng <=100) && (mat >= 0 && mat <=100); //? (avg >= 70 ? "합격" : "불합격") : System.out.println("잘못 입력하셨습니다"));
	*/

	System.out.println( ((kor >=0 && kor <=100) && (eng >= 0 && eng <=100) && (mat >= 0 && mat <=100)) ? (avg >= 70 ? "합격" : "불합격") : "잘못 입력하셨습니다"  );

	}
}
