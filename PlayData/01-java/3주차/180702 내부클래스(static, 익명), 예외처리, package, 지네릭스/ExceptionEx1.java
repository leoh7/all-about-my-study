/*
예외
자바는 에러나 경고나 모두 에러가 난다고 했음.
거기다 더해서, 예외처리라는게 있다.
C에는 캡슐화라는게 데이터의 안정성을 지켜주는데, 
자바는 잘못넣는것에 더해 실행될 때 문제가 될 만한 것을 다 경고를 주게 되어있어
	그러나 꼭 해야 되는 것이 있다. ex) 입력받기

에러가 안나는 예외는 안 잡아도 되
그치만 사용자가 편하게 하기 위해서 바꿔주는게 좋다.(친절하게 하기 위해서)

	그러나 에러가 나는 예외는 반드시 처리해줘야 함.
	대표적으로 IO Exception
	네트워크도, 웹프로그램도 다 이쪽이 필요해

에러를 잡는 것. try -catch
예외가 안나오는 부분까지 예외처리 하면 안 됨. 그만큼 실행시간이 길어지기 때문에.
쓸 데 없는거 예외 잡으면 안됨.

*/

class ExceptionEx1	{
	public static void main(String[] args) {
		int m[] = { 10, 20, 30 };
		try {
			for(int i = 0; i<m.length +1 ; i++){
				System.out.println("m["+i+"] : "+m[i]);
			}	
	//		System.out.println("프로그램 끝");	// 출력되지 않는다. / 위에서 예외가 나왔기 때문에 (i=3) 멈추고, catch로 던진 것.	/ 예외가 있건 없건 무조건 하고 싶다면? / 예외가 있건 없건 제일 마지막에는 실행되라, 하는 블럭을 만들 수 있다. / 그것이 finally
		} catch( ArrayIndexOutOfBoundsException e ){		//트라이 안에서 예외가 발생하면 객체를 만들어(new 할 필요가 없다는 소리)	/	그걸 만들어서 catch로 던져준다.	/ e. 해서 참조변수로 메서드도 가져다 쓸 수가 있다는 소리 /
			System.out.println("배열의 범위를 넘었다.");
			e.printStackTrace();	// 이번 달에는 그냥 예외가 나오면 조금 더 자세히 알려준다, 라고만 알아두자.
		} finally{
			System.out.println("프로그램 끝");
		}

	}
}
/*
Method Summary
Methods inherited from class java.lang.Throwable
addSuppressed, fillInStackTrace, getCause, getLocalizedMessage, getMessage, getStackTrace, getSuppressed, initCause, 
printStackTrace, printStackTrace, printStackTrace,	// printStackTrace 얘네들이 중요	// 웹 프로그램으로 들어가면 자동으로 처리하는 것들이 많아져서
													// 예외를 따라서 예외들이 줄줄이 지어 나오기 때문에 중요함
setStackTrace, toString
Methods inherited from class java.lang.Object
clone, equals, finalize, getClass, hashCode, notify, notifyAll, wait, wait, wait



java.lang.Object
java.lang.Throwable	//	메서드는 Throwable 밖에 없어. 멤버를 쓰기 위함이 아니라 종류별로 묶어주기 위해서 밑으로 상속을 하고 있음.	// Throwable 예외와 에러 클래스들의 조상	// Throwable을 처리해보면 에러와 예외를 다 잡는다.
java.lang.Exception	// 예외클래스의 조상. 모든 예외 클래스들은 얘를 상속받게 되어있다.
java.lang.RuntimeException		// 얘를 상속받은 애들은 에러가 안난다. RuntimeException.	/ 안받은 애들은 에러가 안난다는 소리.
java.lang.IndexOutOfBoundsException
java.lang.ArrayIndexOutOfBoundsException

*/