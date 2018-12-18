import java.util.StringTokenizer;
import java.util.Calender;
class StringStudy_T1{
		// 1980년 1월 12일 생 39살 남자입니다.
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("800112-1111111", "-");
		
		//뽑아내자 / 일부러 StringTokenizer 에다 넣은것
		// 합칠꺼임 이 편이 관리가 편하다
		StringBuffer sb = new StringBuffer();		// 하나의 데이터는 하나로 모으는게 훨씬 더 관리가 편하다는 것

		//반복문
		while( st.hasMoreTokens() ) {
			sb.append( st.nextToken() );					//append 는 sb의 메서드 / 8001121111111로 오든 위처럼 오든 일단 합쳐놓으면 이런 형태
		}
		
		int year = (sb.charAt( 0 ) -48)*10 + sb.charAt(1)-48  //=>  그냥 더하면 104로 나온다 / 꺼내면 문자기 때문에 연산하면 아스키 코드로 연산이 되. - 48 안하면 특히
					+ (charAt(6)=='3' || sb.charAt(6)=='4' ? 2000 : 1900);
		int month = (sb.charAt(2) -48)*10 + sb.charAt(3)-48;
	//	int day = (sb.charAt(4) -48)*10 + sb.charAt(5)-48;	//캐릭터엣 사용하기
		
	/*	char [] ch = sb.toString().toCharArray();
		int day = (ch[4]-48)*10 + ch[5]-48; */

		int day = Integer.parseInt(sb.substring(4,6));		//스트링버퍼 사용하기
		int age = Calendar.getInstance().get( Calendar.YEAR ) - year +1;

		String gender = ch[6]=='1' || ch[6]=='3' ? "남자" : "여자";
		System.out.println( year + "년"+ month +"월"+ day+"일" + age + "살입니다" + gender + "입니다");	//배열 썼었어서 gender는 배열로 쓰였음.... 아...
		

		}
}
