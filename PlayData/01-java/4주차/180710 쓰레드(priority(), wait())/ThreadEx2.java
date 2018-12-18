/*
	Thread�� �켱���� (priority) ����.p738

�������	sleep(),
������	join()
		�켱������ ������ �����ϴ� �޼������ ����
		�߰��� ġ�� ���� �ü�� �����층�� �����Ѱ� �Ǿ
		interrutpt ���ܰ� �߰� �ǰ� ���α׷��� ����ȴ�. -> ����ó��

*/
import java.util.Calendar;

class Thread1 extends Thread {
	public void run(){
		for(int i=0; i<5; i++ ){
			System.out.println( Calendar.getInstance().get( Calendar.SECOND) 
				+ " : " + "ù��° ������" );
			try{
			Thread.sleep(1000);		//1/1000 ��
			}catch( InterruptedException e) { 
				e.printStackTrace();
			}
		}
	}	
}	// Thread1 ��

class Thread2 extends Thread {
	public void run(){
			for(int i=0; i<5; i++ ){
				System.out.println( Calendar.getInstance().get( Calendar.SECOND) 
					+ " : " + "�ι�° ������" );
				try{
				Thread.sleep(1000);		// 1/1000 �� �� �־��ش� // ���� 1�� ����
				}catch( InterruptedException e) { 
					e.printStackTrace();
				}
			}
	}	
}	// Thread2 ��

class Thread3 extends Thread {
	public void run(){
			for(int i=0; i<5; i++ ){
				System.out.println( Calendar.getInstance().get( Calendar.SECOND) 
					+ " : " + "����° ������" );
				try{
				Thread.sleep(1000);		//1/1000 ��
				}catch( InterruptedException e) { 
					e.printStackTrace();
				}
			}
	}
}	// Thread3 ��

class ThreadEx2 {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();

	//	t1.setPriority( Thread.MAX_PRIORITY );
	//	t2.setPriority( Thread.MIN_PRIORITY );

		

		t1.start();
		try{
			t1.join();		// join() �� ���� ������� ��.
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