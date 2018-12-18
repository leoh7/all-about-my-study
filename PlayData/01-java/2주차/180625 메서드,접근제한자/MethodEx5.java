/*
메서드는 한가지 일을 / 완벽하게 하게끔 만들으라고 했지?
명령어가 여러가지 하게 만들면 여러가지 하는거 딱 하나 밖에 못해
한가지만 하게끔 해주면 여러가지 섞어 쓰게 만들 수 있기 때문. 오히려 더 많이.

return
return 값은 한 개 뿐이다.
*/

class MethodEx5 {
	/*
	public void hap (int a, int b){				//덧셈 + 출력 두 가지 일을 하고 있다.	//덧셈만 하고 싶으면? 이거 못 쓴다는 소리
		System.out.println("합은 : "+ (a+b) );
	}
	*/
	// void는 // 결과형, 반환형 자리 // void는 그냥 돌아올 때라 return을 생략해도 되. // 값을 가지고 돌아올 때는 return을 써줘야 되고

	public int hap (int a, int b){
		return a+b;		//매개변수는 넘어온 데이터를 지가 쓸라고 만든 변수		// 지역변수라는 얘기 //자기 혼자밖에 못 쓰는 변수 // 더해서 나온 값은 그럼? 안에서 밖에 못쓰지
	}					//그래서 return;
	public int cha (int a, int b){
		return a-b;
	}
	public int gop (int a, int b){
		return a*b;
	}
	public double mok (int a, int b){
		return (double) a/b;
	}
	//	public double mok (double a, double b){
	//		return a/b;
	//	}


	public static void main(String[] args){

		MethodEx5 me = new MethodEx5();
		int sum = me.hap(5,2);
		System.out.println("합은 : " + sum);
		System.out.println("System.out.println(요안에서) 호출을 할 수도 있다 : "+me.hap(5,2));	//return 값이 없으면 에러가 난단다. return 값이 없는건 println 에 넣지 마세요
		System.out.println("차 : "+me.cha(5,2));
		System.out.println("곱 : "+me.gop(5,2));
		System.out.println("몫 : "+me.mok(5,2));
		//System.out.println("몫 : "+me.mok(5,2));

	}
}