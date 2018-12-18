// User Exception	사용자 정의 예외
// 구구단을 입력받아 출력
// 단 2 ~ 9 범위 밖은 예외로 처리
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UserException extends Exception{	// 상속만 받으면 예외 클래스가 된다!

}

class ExceptionEx3 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		int dan = 0;
		
		try{
				System.out.print("단 입력 : ");
				dan = Integer.parseInt(br.readLine() );
				if(dan<2 || dan>9){
					throw new UserException();		// 없는데 빨갛게 나오는 버그임	// throw 뒤에 예외 클래스만 줘야 되는데 UserException 이 예외 클래스가 아니다? 예외와 오류의 조상인 Exception 을 상속받는다 / 
			} else {
				// 구구단 출력
			}
		} catch( IOException e ){
			e.printStackTrace();
		} catch( UserException e ){
			System.out.println("2~9사이를 입력하세요");
		}

	}
}
/*
구구단은 당연히 2~9 를 입력할껀데, 정수를 받기로 했으니깐 100을 받든 1000을 받든 에러는 아냐.
구구단을 찍겠다고 하니깐 문제지, 프로그램 문법에 위반되진 않지.
그래서 강제로 예외를 직접 만들어서 예외처리를 만들어 볼거야
웹프로그램 할 때 가끔 쓸꺼야

	중요한건 throws 라는 예약어를 썼는데, 강제로 할 땐 throw 를 쓴다.

*/