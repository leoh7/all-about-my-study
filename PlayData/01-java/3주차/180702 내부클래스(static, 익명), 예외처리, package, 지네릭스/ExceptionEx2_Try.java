import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ExceptionEx2_Try {
	public static void main(String []args){
	BufferedReader br = 
		new BufferedReader(new InputStreamReader(System.in));
	int a = 0;
	try{
		System.out.print("������ �Է��ϼ��� : ");
		a = Integer.parseInt(br.readLine());
		System.out.println("���� : "+ 100/a);
	} catch (IOException e){e.printStackTrace();
	} catch (NumberFormatException e){System.out.print("���� ���� �Է��ϼ���.");e.printStackTrace();
	} catch (ArithmeticException e){e.printStackTrace();
	} finally {System.out.println("���α׷��� ���� ���ϴ�.");}
	}	// main
}	// class