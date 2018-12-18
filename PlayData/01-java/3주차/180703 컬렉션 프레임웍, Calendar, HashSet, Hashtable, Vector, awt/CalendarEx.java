/*
생성자 안에서 시간을 찍는데
1년중에 정 가운데 날이 언젠줄 알아요? 7월 2일 / 올해 꺾였어 / 홀수의 정 가운데 날 / 제일 꼭지점 / 
Calendar 클래스는 new가 안되요
Calendar.getInstance 해서 받아와야되. 4번째 방식

메서드도 특이해
생성자 protected / 못 쓴단 소리

static Calendar	getInstance()

static Calendar	getInstance(Locale aLocale)

static Calendar	getInstance(TimeZone zone)

static Calendar	getInstance(TimeZone zone, Locale aLocale)

static 이고 리턴 값이 칼렌더

메서드가 엄청 많은데 주로 쓴느건 get
int	get(int field)

	요일도 겟 시간도 겟 날짜도 겟 겟겟

	매개변수가 int로 되있져
	겟이라는 애한테 어떻게 해야 연도를 가져오고
	어떻게 해야 날짜를 가져 올 수 있냐
	그게 바로 int 값에 의미가 있어요

	앞으로도 매개변수가 int 값이래. 그럼 API 를 반.드.시 확인해야해. 옵션인 경우가 많아요

	이 옵션들이 필드로 정의가 되어 있단 소립니다. 이런식으로요
	예를 들어
	static int	YEAR
	Field number for get and set indicating the year.

	static int	WEEK_OF_YEAR
	Field number for get and set indicating the week number within the current year.

	static int	MONTH	/	1월이 0이에요 +1 반드시 줘야되요
	Field number for get and set indicating the month.

	static int	MINUTE
Field number for get and set indicating the minute within the hour.

static int	MILLISECOND	/	1/1000 초
Field number for get and set indicating the millisecond within the second.

static int	HOUR_OF_DAY / 24시간
Field number for get and set indicating the hour of the day.

static int	DAY_OF_WEEK / 요일 / get 메서드 리턴값이 int에요 / 일요일이 1번 토요일이 7번
Field number for get and set indicating the day of the week.

static int	DAY_OF_MONTH / 이게 한달중에 몇번째 날 / 일 이 된다.
Field number for get and set indicating the day of the month.

static int	AM_PM	/ 리턴값이 int 래. 이 옵션은 뭐여 AM 이면 오전이고 PM 이면 오후야 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
Field number for get and set indicating whether the HOUR is before or after noon.

근데 그 옵션 int 가 또 필드로 정의가 되어 있어서 그걸 가지고 쓰면 되


	그레고리력(음력) 이걸 쓰면 윤년도 잡을 수 있다.
	근데 이게 칼렌더의 자식 클래스여서 그레고리력 쓸 때 칼렌더를 다 쓸 수 있어
	심지어 그레고리력은 new 도 할 수 있다?
	Calendar.HOUR_OF_DAY 이런식으로 쓸 수 있는거
	그래도 객체는 만들어야 되는게 얘의 get 메서드가 static이 아니야


*/
import java.util.Calendar;
import java.util.GregorianCalendar;
public class CalendarEx {
	public CalendarEx() {
		StringBuffer sb = new StringBuffer("년중 ");
		
		Calendar now = Calendar.getInstance();
						// 칼렌더 객체


		sb.append( now.get( Calendar.WEEK_OF_YEAR )+ "주 째인 " );
		sb.append( now.get( now.YEAR ) + "년 " );
		sb.append( now.get( now.MONTH ) + 1 + "월 ");
		sb.append( now.get( Calendar.DAY_OF_MONTH) + "일 " );
		System.out.println(sb);
	
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(
			cal.get( Calendar.HOUR_OF_DAY ) + "시 " +
			cal.get( cal.MINUTE ) + "분 " +
			cal.get( Calendar.SECOND ) + "초 "
		);
	}	// 생성자

	public static void main(String[]args) {
		new CalendarEx();
	}
}

객체 생성 new
extends 상속받는거
멤버 전체가 static
객체를 반환해주는 static 메서드가 존재
Class.forName("클래스 풀 경로");

interface 쓰는 법
상속한 후 모두 재정의
상속을 미리 해놓은 adpater 클래스 를 상속
(특히 구현해야 할 메서드가 딸랑 하나 뿐이라,)익명 내부클래스에 써서 구현해 사용
객체를 대신 생성해주는 메서드를 리턴 받아서(객체를 받아서) 사용 
