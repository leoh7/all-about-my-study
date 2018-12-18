/*
이 숙제는 무조건 푸세요.
어제 오늘 배운 클래스 문법을 뒤섞어서 풀어야 합니다.
소스 최대한으로 줄이세요
복잡하게 하면 안되고 데이터 입력 모르니깐
데이터 입력받았다고 가정하고 들어가는 것

이게 지워지고 있다는 것은 이제 다 돌아왔으니깐 오류가 나서
컨트롤 z를 누르고 있다고 해도 더 이상 누르지 않아도 된다는 소리입니다.
그만 돌아가세요 수정하기 전에것도 날아가기전에
*/

class  ClassStudy {
	//멤버 변수 = 인스턴스 변수
	private int valueA, valueB, valueC, sum;
	private double avg;

	//생성자
	public ClassStudy() {		//default 생성자					//특정 값을 가지도록 초기화 하기 위해 어쩔 수 없이 필요한 생성자 오버로딩
		this(0, 0, 0);			//그냥 붙여봄	//기본 값은 아래 생성자를 참조하여 (0, 0, 0) 으로 초기화한다
	}			
	
	public ClassStudy(int valueA, int valueB, int valueC){		//특정 값을 가지도록 초기화 하기 위해 어쩔 수 없이 필요한 생성자 오버로딩
		this.valueA = valueA;			//this.멤버변수 = 매개변수 / this 안에 있는 멤버변수에, 매개변수를 대입해라
		this.valueB = valueB;
		this.valueC = valueC;
	}

	//멤버 메서드 = 인스턴스 메서드 
	public int total() {				//참조형 매개변수를 쓰면 어떨까?
		sum = valueA + valueB + valueC;
		return sum;
	}
	public double average() {
		avg = (double)sum / 3;
		return avg;
	}
	public String pass() {
		if(avg >= 70) {
			return "합격";
		}else{				//else가 없다면? if(avg >= 70){참: return "합격" }{거짓: return "불합격"} 
			return "불합격";
		}
	}



	public static void main(String[] args) {

		ClassStudy cs = new ClassStudy( 47, 55, 91);
//		System.out.println("value A ="+cs.valueA +"\t"+"value B ="+ cs.valueB +"\t"+"value C ="+ cs.valueC);		// test 용 코드
		
		System.out.println( "총점 : " + cs.total() );
		System.out.printf( "평균 : %.2f\n", cs.average() );
		System.out.println( "당락 : " + cs.pass() );	// 70점 이상이면 "합격"
			if(true){System.out.println("참");}
			else if	{System.out.println("거짓");}
	}	//main

}	//class


/*
총점 : 193
평균 : 64.33
당락 : 불합격
*/