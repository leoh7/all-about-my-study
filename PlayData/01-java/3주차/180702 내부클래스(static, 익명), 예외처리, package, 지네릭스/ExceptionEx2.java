/*
������ �߻��ϴ� ����
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class ExceptionEx2	{
//	public static void main(String[] args) throws IOException {		// �ѹ��� �� ������
	public static void main(String[] args) {

		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );	// ���⿡ �� �͵� �͸���Ŭ�����ΰ�?
		int a = 0;
		try {
		System.out.print("������ �Է��ϼ��� : ");
		a = Integer.parseInt(br.readLine() );	// ���α׷��� ���߱� ������ ������ ���� / ������� ���α׷��� ���߸� �����Ŵ / ���ܰ� �߻��ϴ� �޼��忡�� ������.
		System.out.println("���� : " + 100/a);
		} catch(IOException e){
			e.printStackTrace();
		} catch(NumberFormatException e){
			System.out.println("���ڸ� �Է��� �ּ���");
		} catch(ArithmeticException e){
			System.out.println("���� 0���� ���ڸ� ������ ��û�̵� �ֳ�?");
		} finally { System.out.println("���α׷� ��");}
		
//		System.out.println("���� : " + 100/a);	//	interupt / ��ǻ�Ͱ� ������ ���� �ϰ� �ִµ� ���ذ� ���� �� / ���U / �ɰ��� ������. ���� � ���ڵ� 0���� ������ �ȵǴ� ��. / 
//		try �ȿ� ���� �ʾƼ� 0���� ������ �� try catch�� ����� �۵����� �ʴ´�.
	}
}
