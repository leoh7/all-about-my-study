/*
에러가 발생하는 예외
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class ExceptionEx2	{
//	public static void main(String[] args) throws IOException {		// 한번에 다 던지기
	public static void main(String[] args) {

		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );	// 여기에 들어간 것도 익명내부클래스인가?
		int a = 0;
		try {
		System.out.print("정수를 입력하세요 : ");
		a = Integer.parseInt(br.readLine() );	// 프로그램을 멈추기 때문에 에러가 난다 / 윈도우는 프로그램이 멈추면 종료시킴 / 예외가 발생하는 메서드에서 던졌다.
		System.out.println("정수 : " + 100/a);
		} catch(IOException e){
			e.printStackTrace();
		} catch(NumberFormatException e){
			System.out.println("숫자만 입력해 주세요");
		} catch(ArithmeticException e){
			System.out.println("세상에 0으로 숫자를 나누는 멍청이도 있나?");
		} finally { System.out.println("프로그램 끝");}
		
//		System.out.println("정수 : " + 100/a);	//	interupt / 컴퓨터가 열심히 일을 하고 있는데 방해가 들어온 것 / ㅅ밬 / 심각한 문제임. 세상에 어떤 숫자도 0으로 나누면 안되는 것. / 
//		try 안에 있지 않아서 0으로 나눴을 때 try catch가 제대로 작동하지 않는다.
	}
}
