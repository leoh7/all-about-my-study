/*
������ �ȿ��� �ð��� ��µ�
1���߿� �� ��� ���� ������ �˾ƿ�? 7�� 2�� / ���� ������ / Ȧ���� �� ��� �� / ���� ������ / 
Calendar Ŭ������ new�� �ȵǿ�
Calendar.getInstance �ؼ� �޾ƿ;ߵ�. 4��° ���

�޼��嵵 Ư����
������ protected / �� ���� �Ҹ�

static Calendar	getInstance()

static Calendar	getInstance(Locale aLocale)

static Calendar	getInstance(TimeZone zone)

static Calendar	getInstance(TimeZone zone, Locale aLocale)

static �̰� ���� ���� Į����

�޼��尡 ��û ������ �ַ� ������ get
int	get(int field)

	���ϵ� �� �ð��� �� ��¥�� �� �ٰ�

	�Ű������� int�� ������
	���̶�� ������ ��� �ؾ� ������ ��������
	��� �ؾ� ��¥�� ���� �� �� �ֳ�
	�װ� �ٷ� int ���� �ǹ̰� �־��

	�����ε� �Ű������� int ���̷�. �׷� API �� ��.��.�� Ȯ���ؾ���. �ɼ��� ��찡 ���ƿ�

	�� �ɼǵ��� �ʵ�� ���ǰ� �Ǿ� �ִ� �Ҹ��ϴ�. �̷������ο�
	���� ���
	static int	YEAR
	Field number for get and set indicating the year.

	static int	WEEK_OF_YEAR
	Field number for get and set indicating the week number within the current year.

	static int	MONTH	/	1���� 0�̿��� +1 �ݵ�� ��ߵǿ�
	Field number for get and set indicating the month.

	static int	MINUTE
Field number for get and set indicating the minute within the hour.

static int	MILLISECOND	/	1/1000 ��
Field number for get and set indicating the millisecond within the second.

static int	HOUR_OF_DAY / 24�ð�
Field number for get and set indicating the hour of the day.

static int	DAY_OF_WEEK / ���� / get �޼��� ���ϰ��� int���� / �Ͽ����� 1�� ������� 7��
Field number for get and set indicating the day of the week.

static int	DAY_OF_MONTH / �̰� �Ѵ��߿� ���° �� / �� �� �ȴ�.
Field number for get and set indicating the day of the month.

static int	AM_PM	/ ���ϰ��� int ��. �� �ɼ��� ���� AM �̸� �����̰� PM �̸� ���ľ� ����������������������������������������
Field number for get and set indicating whether the HOUR is before or after noon.

�ٵ� �� �ɼ� int �� �� �ʵ�� ���ǰ� �Ǿ� �־ �װ� ������ ���� ��


	�׷�����(����) �̰� ���� ���⵵ ���� �� �ִ�.
	�ٵ� �̰� Į������ �ڽ� Ŭ�������� �׷����� �� �� Į������ �� �� �� �־�
	������ �׷������� new �� �� �� �ִ�?
	Calendar.HOUR_OF_DAY �̷������� �� �� �ִ°�
	�׷��� ��ü�� ������ �Ǵ°� ���� get �޼��尡 static�� �ƴϾ�


*/
import java.util.Calendar;
import java.util.GregorianCalendar;
public class CalendarEx {
	public CalendarEx() {
		StringBuffer sb = new StringBuffer("���� ");
		
		Calendar now = Calendar.getInstance();
						// Į���� ��ü


		sb.append( now.get( Calendar.WEEK_OF_YEAR )+ "�� °�� " );
		sb.append( now.get( now.YEAR ) + "�� " );
		sb.append( now.get( now.MONTH ) + 1 + "�� ");
		sb.append( now.get( Calendar.DAY_OF_MONTH) + "�� " );
		System.out.println(sb);
	
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(
			cal.get( Calendar.HOUR_OF_DAY ) + "�� " +
			cal.get( cal.MINUTE ) + "�� " +
			cal.get( Calendar.SECOND ) + "�� "
		);
	}	// ������

	public static void main(String[]args) {
		new CalendarEx();
	}
}

��ü ���� new
extends ��ӹ޴°�
��� ��ü�� static
��ü�� ��ȯ���ִ� static �޼��尡 ����
Class.forName("Ŭ���� Ǯ ���");

interface ���� ��
����� �� ��� ������
����� �̸� �س��� adpater Ŭ���� �� ���
(Ư�� �����ؾ� �� �޼��尡 ���� �ϳ� ���̶�,)�͸� ����Ŭ������ �Ἥ ������ ���
��ü�� ��� �������ִ� �޼��带 ���� �޾Ƽ�(��ü�� �޾Ƽ�) ��� 
