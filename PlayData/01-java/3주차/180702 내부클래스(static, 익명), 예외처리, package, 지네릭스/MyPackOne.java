package mypack;
import static java.lang.System.out;

public class  MyPackOne{
	public void one(){
		out.println("MyPackOne �޼���");
	}

	
}

/*
import -> �ش� Ŭ������ ������ �ٸ��� ������ �ؾߵȴ�. ������ ������ ������

class ������ ��ġ!(java������ ��ġ�� ����ֵ� ��� ����.)
	package mypack;	//////////////////// ��Ű���� ������ �ҹ��ڷ� ����. ����̿� ��� ///////////////////////
	mypack �̶�� ������ ����� �ű�� �־����
		main���� ����� ���� �� ���� �ؿ� �־ ������ import �ؾߵȴ� �׷��ݾ�
		import mypack.MypackOne; �̷���

	�������� �� ��Ű�� ������ �ɼ��� ��� ��.
	javac -d. MyPackOne
	�������� �������� .
	�������� �������� ..
	-d		directory


*/