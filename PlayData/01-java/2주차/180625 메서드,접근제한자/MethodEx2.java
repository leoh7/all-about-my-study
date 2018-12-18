
//int sum=0;	/ C에서는 class 밖에 전역변수를 설정하게 되 있었어 / 게다가 항상 static 으로 설정이 됨.
class MethodEx2{
	int sum=0;		//엄밀히 말하면 자바에는 전역변수가 없다. / class 밖에다 변수를 설정할 수 없기 때문에 / 가장 큰 영역안에 있는걸 자바에서는 전역변수 라고 하는 것. / 이것은 멤버 변수./ 모든 멤버변수는 전역변수이다.(자바에서는) / heap 에 저장 됨

	
	public void hap(){
		int sum = 0;		// 지역 변수 / gop() 에서 int sum 을 선언해도 문제가 되지 않는다.
		for(int i=0; i<10 ;i++ ){ 
			sum += i + 1;
		}System.out.println("1~10의 합은 = " + sum);
	}
	public void gop(){
		int sum = 1;			// 지역 변수
		for(int i=0; i<10 ;i++ ){ 
			sum *= i+1;
			System.out.println("곱셈상황 보고: " + sum);
		}System.out.println("1~10의 곱은 = " + sum);
	}
	
	
	public static void main (String [] args){
		MethodEx2 me = new MethodEx2();
		me.hap();	// 1 ~ 10까지 합을 출력	합: 55			//원래는 합하는 메서드, 출력하는 메서드 이렇게 두 가지로 나누는게 좋다. 한가지 일을/완벽하게
		me.gop();	// 1 ~ 10까지 곱을 출력	곱: 3628800
	}	//main
}	//class