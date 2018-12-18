/*
2개로 나눠진 토큰을 하나로 합쳐서 
80을 끄집어 내고
01
12 끄집어 내고
					*연도를 숫자로 체크해야 합니다 굉장한 힌트*
오늘 날짜랑 비교해서 나이를 만들고 callender
	(2018 - 태어난 날)
7번째 값으로 남,여 구분	// 근데 이게 3 남자 4 여자->면 2000년 이후에 태어난

방향이 여러갭니다요


*/		//1980년 1월 12일 38살 남자입니다 로 출력

import java.util.StringTokenizer;

class StringStudy{
	//인스턴스 변수
	public static char[] year, month, date;
	public String firstNum, secondNum;


	//인스턴스 메서드
	
	
		

	public static void main(String[] args) {
		StringTokenizer st
			= new StringTokenizer( "800112-1111111", "-");		// StringTokenizer 인스턴스화 -> st
		StringStudy ss = new StringStudy();						//StringStudy 인스턴스화 -> ss

		//배열 생성


		/*
		String g = "line";
		char c = g.charAt(0);	//char c에는 '1'이 담긴다.
		char[] c_arr = g.toCharArray();	// 크기가 4인 char 배열 ['l','i','n','e']
		*/


			st.hasMoreTokens(); 	//토큰 갖고 있냐? 있으면 트루
			ss.firstNum = st.nextToken();
			st.hasMoreTokens();
			ss.secondNum = st.nextToken();
			System.out.println("시험용입니다 firstNum: "+ss.firstNum);
			System.out.println("시험용입니다 secondNum: "+ss.secondNum);
			
			ss.firstNum.subString(0,1);

			//char year [] = ss.firstNum.toCharArray();
			
			
//		}

	}
}
