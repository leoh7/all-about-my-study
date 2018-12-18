import java.util.StringTokenizer;	// lang -> util 순으로 많이 쓴다. / util 은 꼭 써야되는건 아니지만 쓰면 많이 편한 클래스들이 포진해있다

class  StringTokenizerEx{

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer( "2018/06/27", "/" );	// 매개변수가 없지 / 디폴트 생성자로 호출한거지 / 에러가 나네? / 디폴트 생성자가 없다는것	/ 생성자는 리턴값이 없어서 잘라서 지가 그냥 갖고 있다. 결국 얘가 하란대로 해야함. / 이런 경우 많음
		
		System.out.println( "개수 : " +st.countTokens() );			// 뒤에 남은 토큰 수를 샌다
			
			while( st.hasMoreTokens() ){	//토큰 갖고 있냐? 있으면 트루를 리턴
			System.out.println( "Token : " + st.nextToken() ); 
			}
			System.out.println( "개수 : " +st.countTokens() );	// 여기까지 오면 남은 토큰이 없으니깐


		StringTokenizer st2 = new StringTokenizer( "2018/06/27", "/", true );	//
			System.out.println( "개수 : " +st2.countTokens() );
				
				while( st2.hasMoreTokens() ){	//토큰 갖고 있냐? 있으면 트루
				System.out.println( "Token : " + st2.nextToken() );
			}
			System.out.println( "개수 : " +st2.countTokens() );



// 큰 문자열을 잘라서 나오는 개개 를 token 이라고 부른다.
// 이런걸 반복문으로 돌리는게 여기저기 많이 나옴 / "2018" "06" "27" 이렇게 잘려있는 토큰들 중 "2018"의 앞에 포인터가 있다가 / 토큰 있냐? 있으면 true, 없으면 false 해서 반복문

// StringTokenizer(String str) / 적어도 문자열 하나는 던져야한다는 것. / 문자열을 자르는 클래스거등
// 그런 이유로 디폴트 생성자가 없다.	/ /는구분자, 델리미터 / 구분자, 델리미터를 안 주면 의미없는 여백, 화이트 스페이스를 기준으로 글자를 잘라준다.
// StringTokenizer(String str, String delim) / 이게 델리미터를 주는것.

// StringTokenizer(String str, String delim, boolean returnDelims) / 생성자에 boolean 값이 들어 올 땐 보통 맨 마지막에 들어간다 / 기본값은 boolean / 안 할꺼면 그냥 안 쓰면 되. 앞에 게 그런 거라고 생각하면 됨 / 


	}
}
