/*
����
�ڹٴ� ������ ��� ��� ������ ���ٰ� ����.
�ű�� ���ؼ�, ����ó����°� �ִ�.
C���� ĸ��ȭ��°� �������� �������� �����ִµ�, 
�ڹٴ� �߸��ִ°Ϳ� ���� ����� �� ������ �� ���� ���� �� ��� �ְ� �Ǿ��־�
	�׷��� �� �ؾ� �Ǵ� ���� �ִ�. ex) �Է¹ޱ�

������ �ȳ��� ���ܴ� �� ��Ƶ� ��
��ġ�� ����ڰ� ���ϰ� �ϱ� ���ؼ� �ٲ��ִ°� ����.(ģ���ϰ� �ϱ� ���ؼ�)

	�׷��� ������ ���� ���ܴ� �ݵ�� ó������� ��.
	��ǥ������ IO Exception
	��Ʈ��ũ��, �����α׷��� �� ������ �ʿ���

������ ��� ��. try -catch
���ܰ� �ȳ����� �κб��� ����ó�� �ϸ� �� ��. �׸�ŭ ����ð��� ������� ������.
�� �� ���°� ���� ������ �ȵ�.

*/

class ExceptionEx1	{
	public static void main(String[] args) {
		int m[] = { 10, 20, 30 };
		try {
			for(int i = 0; i<m.length +1 ; i++){
				System.out.println("m["+i+"] : "+m[i]);
			}	
	//		System.out.println("���α׷� ��");	// ��µ��� �ʴ´�. / ������ ���ܰ� ���Ա� ������ (i=3) ���߰�, catch�� ���� ��.	/ ���ܰ� �ְ� ���� ������ �ϰ� �ʹٸ�? / ���ܰ� �ְ� ���� ���� ���������� ����Ƕ�, �ϴ� ���� ���� �� �ִ�. / �װ��� finally
		} catch( ArrayIndexOutOfBoundsException e ){		//Ʈ���� �ȿ��� ���ܰ� �߻��ϸ� ��ü�� �����(new �� �ʿ䰡 ���ٴ� �Ҹ�)	/	�װ� ���� catch�� �����ش�.	/ e. �ؼ� ���������� �޼��嵵 ������ �� ���� �ִٴ� �Ҹ� /
			System.out.println("�迭�� ������ �Ѿ���.");
			e.printStackTrace();	// �̹� �޿��� �׳� ���ܰ� ������ ���� �� �ڼ��� �˷��ش�, ��� �˾Ƶ���.
		} finally{
			System.out.println("���α׷� ��");
		}

	}
}
/*
Method Summary
Methods inherited from class java.lang.Throwable
addSuppressed, fillInStackTrace, getCause, getLocalizedMessage, getMessage, getStackTrace, getSuppressed, initCause, 
printStackTrace, printStackTrace, printStackTrace,	// printStackTrace ��׵��� �߿�	// �� ���α׷����� ���� �ڵ����� ó���ϴ� �͵��� ��������
													// ���ܸ� ���� ���ܵ��� ������ ���� ������ ������ �߿���
setStackTrace, toString
Methods inherited from class java.lang.Object
clone, equals, finalize, getClass, hashCode, notify, notifyAll, wait, wait, wait



java.lang.Object
java.lang.Throwable	//	�޼���� Throwable �ۿ� ����. ����� ���� ������ �ƴ϶� �������� �����ֱ� ���ؼ� ������ ����� �ϰ� ����.	// Throwable ���ܿ� ���� Ŭ�������� ����	// Throwable�� ó���غ��� ������ ���ܸ� �� ��´�.
java.lang.Exception	// ����Ŭ������ ����. ��� ���� Ŭ�������� �긦 ��ӹް� �Ǿ��ִ�.
java.lang.RuntimeException		// �긦 ��ӹ��� �ֵ��� ������ �ȳ���. RuntimeException.	/ �ȹ��� �ֵ��� ������ �ȳ��ٴ� �Ҹ�.
java.lang.IndexOutOfBoundsException
java.lang.ArrayIndexOutOfBoundsException

*/