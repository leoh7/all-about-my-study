/* ���� �߿� / ���� �����ϸ� ���, ���ϸ� �����

*/
import java.util.Date;
class ToStringEx {
	public String toString(){
		return "ToStringEx toString �޼��� �Դϴ�.";
	}
		
	public static void main (String [] args){
		String str = "Hello";					// str �� ��������. ���������� ����϶� / �����͸� ����
		System.out.println("String : "+ str);
		System.out.println("String : "+ str.toString());
		
		ToStringEx se = new ToStringEx();
		System.out.println("ToStringEx : "+ se);	// ���������� �������, �ϰ� ���� �ߴ��� ������. �� �ּҰ� �״�� ��������.


		Date date = new Date();
		System.out.println("Date : "+ date);	// �굵 ������ ����µ�? �ð��� ������?


		/*
		��� �������� ������ ��� �����Ͱ� ����
		�� ���̰� toString �� �ֳ� ����
		System.out.println �� �� ���������� ���� (str.toString()) �� �ϱ�� �Ǿ��־� /toString() �޼��带 ȣ���ϱ�� �Ǿ��ִٰ�
		toString() �̶�� �޼��尡 ����ֳĸ� Object�� �־�


String	toString()
Returns a string representation of the object.

		�θ����׵� ������ �ִµ� �ڽĲ����� �ϸ� �ڽĲ� �޼��尡 ������� ������
		�ڱⰡ toString�� ������ ������ �� �ȿ��� ��������� �����Ǹ� �س����ž�
		�ٵ� �� �������̵带 �� �س����� �������� �״�� ���� ���Դ���!!!!!!!!!!!!!!!!
		�׷��� toString �� �ִ��� API �� �� Ȯ���غ���
		����������? �θ� �����ߴµ� �ڽ� �� ����Ǵ°�? ��/?
		*/


	}

}