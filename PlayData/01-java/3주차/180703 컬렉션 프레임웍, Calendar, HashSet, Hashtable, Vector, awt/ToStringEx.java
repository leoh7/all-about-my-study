/* 개념 중요 / 개념 이해하면 쉬운데, 못하면 개어렵

*/
import java.util.Date;
class ToStringEx {
	public String toString(){
		return "ToStringEx toString 메서드 입니다.";
	}
		
	public static void main (String [] args){
		String str = "Hello";					// str 은 참조변수. 참조변수를 출력하라 / 데이터를 찍음
		System.out.println("String : "+ str);
		System.out.println("String : "+ str.toString());
		
		ToStringEx se = new ToStringEx();
		System.out.println("ToStringEx : "+ se);	// 참조변수를 만들었어, 하고 찍어라 했더니 참조값. 즉 주소가 그대로 찍혀버림.


		Date date = new Date();
		System.out.println("Date : "+ date);	// 얘도 참조값 찍었는데? 시간이 나오네?


		/*
		어떤건 참조값이 나오고 어떤건 데이터가 나와
		그 차이가 toString 이 있냐 없냐
		System.out.println 할 때 내부적으로 전부 (str.toString()) 을 하기로 되어있어 /toString() 메서드를 호출하기로 되어있다고
		toString() 이라는 메서드가 어디있냐면 Object에 있어


String	toString()
Returns a string representation of the object.

		부모한테도 같은게 있는데 자식꺼에서 하면 자식꺼 메서드가 나오기로 되있지
		자기가 toString을 재정의 했으면 그 안에서 출력형식을 재정의를 해놓은거야
		근데 이 오버라이드를 안 해놨으면 참조값이 그대로 찍혀 나왔던것!!!!!!!!!!!!!!!!
		그래서 toString 이 있는지 API 볼 때 확인해보자
		다형성이져? 부모꺼 실행했는데 자식 거 실행되는거? 음/?
		*/


	}

}