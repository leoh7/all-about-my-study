/*
배열과 sort 연습 (알고리즘 연습)

	셀렉션 sort
m이라는 방
0	1	2	3	4
25	8	16	43	35

	가정 : 
	맨 앞에 있는 a방이 제일 크다고 가정
	25가 제일 큰지 나머지한테 다 물어
	(물을 때 얘가 더 작으냐?)25가 제일 크면 가만히 있어도 되, 아니면 a에다 써
	이렇게 하면 일단 최대값을 구할 수 있음
	
	가정이라는 건 이게 내가 원하는 바 이다, 라고 생각하는거니까, 이게 아닌걸 증명하는 과정

	
	rank :
m방		0	1	2	3	4
		25	8	16	43	35

rank방	0	1	2	3	4 	등수를 저장하기 위한 방(배열)
		
		밖의 i for 기준
		안의 j for 비교

	가정 : 0이 1등이다
	인덱스 0번이 (어려움: 자기자신 빼고) 비교했더니 작네? 등수를 점점 낮춰가기
		

sort는 데이터 관리를 하면 항상 등장함
항상 두가지 결과가 나옴 / 오름차순 / 내림차순
					 어센딩	  디센딩
	왜 종류가 많냐
	셀렉션 소트가 제일 쉬운데, 제일 느려.

정렬은 배열 안에 있는 수치를 바꿔주는게 정렬이야
	일단 0은 기준으로 잡고 다른 것과 바꿈
	나는 왼쪽에 작은게 오게 하고 싶어 -> 왼쪽에 작은게 오면 아무것도 안하면 됨
	[0]25	<->	[1]8
	[0]8	<-> [1]16	...

	한바퀴 돌면 i for문이 끝나면서 0번이 완료된다.
	비교가 끝난 0번은 빼면 됨.
	처음 기준이 0이었지
	한바퀴 돌았지
	기준이 1이 되지. 비교는 기준 다음방부터, 라고 하면 되지.


*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
class ArrayEx2 {


	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ) );

		int m[] = new int[5];
		for( int i=0; i<m.length; i++){				//입력값
			System.out.print("정수 : " );
			m[i] = Integer.parseInt( br.readLine() );
		}

	System.out.println();	// 이쁘게 이쁘게 띄어쓰기
		


		// 최대값
		int a = m[0];	//a 라는 변수에다가 m[0] 의 참조
		for(int i=0; i<m.length ; i++){
			if(a <= m[i]){				// 내가 원하지 않는걸 물어보기!
				a = m[i];
			}else{						// 원하면? 냅둬 그냥

			}
		}System.out.println("최대값 : "+ a);
		
		
		

		// 최소값
		int b = m[0];	//a 라는 변수에다가 m[0] 의 참조	/ 새로 변수 생성할 것 없이 그냥 a = m[0]; 만 해도 된다.
		for(int i=0; i<m.length ; i++){
			if(b >= m[i]){
				b = m[i];
			}else{

			}
		}System.out.println("최소값 : "+ b);
		

		//석차구하기
/*
			rank :
m방		0	1	2	3	4
		25	8	16	43	35

rank방	0	1	2	3	4 	등수를 저장하기 위한 방(배열)
		가정 : 0번 방이 제일 크다
	c= 25 다,	m[0]과 비교, 같다				5
				m[1]과 비교, 크다 (count--)	4
				m[2]과 비교, 크다 (count--)	3
				m[3]과 비교, 작다				3
				m[4]과 비교, 작다				3
*/
		
		int []rank = new int[5];
		//선생님꺼 rank
		for( int i=0; i<m.length ; i++){		//기준
			rank[i] = 1;						//j for문이 비교 걸기 전에만 0번방이 1등이라고 가정하고 반복문 돌리기
			for(int j=0; j<m.length ; j++ ){	//비교
				if( m[i] < m[j]) rank[i]++; 	// 기준이 비교방보다 작다? 그럼 1등이 아니네/ 그럼 랭크에 rank[i] ++;
			}
		}
		for (int i=0; i<m.length; i++){						//for 문을 이렇게 작업별(기능별)로 나눠놓는 것이 수정은 물론이고 깔끔함에도 좋다.
			System.out.println("m["+i+"] 등수" + rank[i] );	
		}

		// 선생님꺼 끝

/*		
		// 내꺼 rank
		for(int i =0; i<rank.length; i++){
			int c = m[i];
			int count = rank.length;

			for(int j=0; j<rank.length; j++) {
				if(c < m[j]){		// c가 배열 i번 째 값보다 작으면 실행
				}else if(c > m[j]){		// c가 배열 i번 째 값보다 크면 실행
					count--;
				}else{}
			}
			rank[i] = count;
			System.out.println("배열"+"["+i+"]"+"는"+(rank[i] = count) + "등");	// j for
		}	// i for
		// 내꺼 끝
*/
/*
		// 선택 정렬
		int temp = 0;
		for(int i=0; i<m.length; i++){			// 기준	전체방보다 하나 적게
			for(int j=i+1; j<m.length; j++){	// 비교	기준 다음방 부터
				if( m[i] > m[j] ){				// 기준 > 비교	오름차순	/	약자로 asc 어센딩
					temp = m[i];				// 기준 < 비교	내림차순 m[i] < m[j	/	약자로 desc 디센딩
					m[i] = m[j];
					m[j] = temp;
				}
			}	
		}

*/
		Arrays.sort( m );

		for( int i = 0 ; i<m.length ; i++){
			System.out.println("m["+i+"] : "+m[i] );
		}



	}
}

/*
과연 왠만한건 다 갖고 있는 자바가 정렬을 굳이 해야하는가?
있어여 진짜로
있는데 간과하면 안되는게 애석하게도 오름차순, 내림차순 이 부등호 하나 차이라
기존에 짜여져있는건 전부 오름차순으로 되어있음

class Arrays
필드도 없고, 생성자도 없다. 그러면
멤버 몇개가 / 전부가 스테틱인가?
	배열을 쓰기 편하게 
	static void	sort(int[] a) / 배열 넣으면 소트-
*/