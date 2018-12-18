// StringTokenizerEx 에서 인스턴스화 될 클래스

class ForStringTokenizerEx {
	
}
/*
데이터의 길이 고정
데이터의 타입 숫자로 고정

?BufferedReader 안에서 객체를 만들 수 있나? / 버퍼드리더 생성 입력값에서 int value = Integer.parseInt( br.readLine(System.in));

		입력값을 받는다 / - 없이 880731 1 / 7자리 숫자만 받음
		
		배열 생성											int firstYMD[][] = new int[2][2]

		입력값을 ++토큰 분리++ 매서드에 던진다					// char[]	toCharArray() 내일 숙제 할 때 쓸 수도 있음 // 문자 배열로 쓰는것
															// String[]	split?(String regex) / regex 를 기준으로 해서 문자를 잘라주는것.
		앞 토큰	880731
		뒷 토큰	1111111		//앞자리 1,2,3,4 확인하기 / 메서드(){a,b,c,d에 각각 boolean startsWith(String prefix) 이용해서 검사하기 || }

		앞토큰 2, 2, 2 배열에 잘라넣기
			year[][] = [][]88
			month[] = 07
			int[] = 31
		




2칸 배열 생성
토큰을 자르고 앞에 000000 6개 숫자만 2칸 2칸 2칸 담는다
- 뒤의 값은 1****** 첫번째 값만 남기고 나머지 *로 바꿈
	
	if() - 뒤의 첫번째 값이 1~4 값이 아니면 다시 입력
		 - 1~2 면 19, 3~4 면 20
		 - 월이 1~12 사이가 아니면 다시 입력
		 - 일이 1~31 사이가 아니면 다시 입력
		 - 총 갯수가 13이 아니면 다시 입력 - '-' 빼고 입력캐 함

 - 1번 배열 년도
 - 2번 배열 월
 - 3번 배열 일
		
year	[] 80
month	[] 01
date	[] 12


- 1	과	****** 따로 관리(후자는 그냥 출력)

+할 수 있으면 날짜 클래스 불러올 수 있도록
+할 수 있으면 태어난 날의 요일도 불러올 수 있도록 / day	[] ?
+할 수 있으면 오늘 날짜 이전의 값만 유효하게끔
	boolean	isBefore(Year other)	/file:///C:/Users/Playdata/Desktop/jdk-8u171-docs-all/docs/api/java/time/Year.html#isBefore-java.time.Year-

String	toString()	지금 연도를 String 값으로 출력(null 이 없다)


	
*/