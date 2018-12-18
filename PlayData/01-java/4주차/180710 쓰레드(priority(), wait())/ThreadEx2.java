/*
	Thread의 우선순위 (priority) 참고.p738

권장사항	sleep(),
강제성	join()
		우선순위를 강제로 조정하는 메서드들을 쓰면
		중간에 치고 들어가서 운영체제 스케쥴링을 방해한게 되어서
		interrutpt 예외가 뜨게 되고 프로그램이 종료된다. -> 예외처리

*/
import java.util.Calendar;

class Thread1 extends Thread {
	public void run(){
		for(int i=0; i<5; i++ ){
			System.out.println( Calendar.getInstance().get( Calendar.SECOND) 
				+ " : " + "첫번째 쓰레드" );
			try{
			Thread.sleep(1000);		//1/1000 초
			}catch( InterruptedException e) { 
				e.printStackTrace();
			}
		}
	}	
}	// Thread1 끝

class Thread2 extends Thread {
	public void run(){
			for(int i=0; i<5; i++ ){
				System.out.println( Calendar.getInstance().get( Calendar.SECOND) 
					+ " : " + "두번째 쓰레드" );
				try{
				Thread.sleep(1000);		// 1/1000 초 를 넣어준다 // 현재 1초 지연
				}catch( InterruptedException e) { 
					e.printStackTrace();
				}
			}
	}	
}	// Thread2 끝

class Thread3 extends Thread {
	public void run(){
			for(int i=0; i<5; i++ ){
				System.out.println( Calendar.getInstance().get( Calendar.SECOND) 
					+ " : " + "세번째 쓰레드" );
				try{
				Thread.sleep(1000);		//1/1000 초
				}catch( InterruptedException e) { 
					e.printStackTrace();
				}
			}
	}
}	// Thread3 끝

class ThreadEx2 {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();

	//	t1.setPriority( Thread.MAX_PRIORITY );
	//	t2.setPriority( Thread.MIN_PRIORITY );

		

		t1.start();
		try{
			t1.join();		// join() 은 먼저 끝내라는 것.
		}catch( InterruptedException e) { 
			e.printStackTrace(); 
		}

		t2.start();
		t3.start();
	}
}



/*

Fields
Modifier and Type	Field and Description
static int	MAX_PRIORITY
The maximum priority that a thread can have.
static int	MIN_PRIORITY
The minimum priority that a thread can have.
static int	NORM_PRIORITY
The default priority that is assigned to a thread.



void	join()
Waits for this thread to die.
void	join(long millis)
Waits at most millis milliseconds for this thread to die.
void	join(long millis, int nanos)
Waits at most millis milliseconds plus nanos nanoseconds for this thread to die.
*/