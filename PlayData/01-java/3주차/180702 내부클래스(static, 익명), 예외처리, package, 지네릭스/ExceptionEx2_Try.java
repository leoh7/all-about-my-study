import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ExceptionEx2_Try {
	public static void main(String []args){
	BufferedReader br = 
		new BufferedReader(new InputStreamReader(System.in));
	int a = 0;
	try{
		System.out.print("정수를 입력하세요 : ");
		a = Integer.parseInt(br.readLine());
		System.out.println("정수 : "+ 100/a);
	} catch (IOException e){e.printStackTrace();
	} catch (NumberFormatException e){System.out.print("정수 값을 입력하세요.");e.printStackTrace();
	} catch (ArithmeticException e){e.printStackTrace();
	} finally {System.out.println("프로그램이 끝이 납니다.");}
	}	// main
}	// class