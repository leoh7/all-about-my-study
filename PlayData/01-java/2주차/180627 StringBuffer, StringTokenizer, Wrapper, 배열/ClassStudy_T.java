/*
이 숙제는 무조건 푸세요.
어제 오늘 배운 클래스 문법을 뒤섞어서 풀어야 합니다.
소스 최대한으로 줄이세요
복잡하게 하면 안되고 데이터 입력 모르니깐
데이터 입력받았다고 가정하고 들어가는 것

*/

class  ClassStudy_T {
	int kor, eng, mat;

	public ClassStudy_T(){}	//default 생성자
	public ClassStudy_T( int kor, int eng, int mat){
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int total(){		//매개변수는 던졌을 때만 받아야된다. / 안던졌는데 받으면 문제가 생김
		return kor + eng + mat;	//tot = kor + eng + mat; 이런식으로 리턴도 가능하다
	}

	public double average(){
		return total() / 3.0;	//이런식으로 메서드를 쓰는게 가능하다, 메서드는 이러려고 쓰는 것.
	}
	
	public String pass() {
		return average() >= 70 ? "합격" : "불합격";
	}

	
	public static void main(String[] args) {
		ClassStudy_T cs = new ClassStudy_T( 47, 55, 91);		// 생성자라는 멤버변수를 초기화하는 역할 / 최소한 변수가 3개는 필요하다는 소리
		System.out.println( "총점 : " + cs.total() );
		System.out.printf( "평균 : %.2f\n", cs.average() );
		System.out.println( "당락 : " + cs.pass() );	// 70점 이상이면 "합격"

	}	//main
}	//class


/*
총점 : 193
평균 : 64.33
당락 : 불합격
*/