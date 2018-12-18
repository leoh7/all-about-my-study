// Daemon thread example
public class ThreadEx10 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());
		t.setDaemon(true); // **이 부분이 없으면 종료되지 않는다.**
		t.start();

		for(int i = 1; i <= 10; i++) {
			try {
			    Thread.sleep(1000);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}

			System.out.println(i);
			if(i==5) {
			    autoSave = true;
			}
		}

		System.out.println("프로그램을 종료합니다.");
	}

	@Override
	public void run() {
		// **데몬쓰레드 실행을 위한 무한루프 실행 및 특정 조건 일때 실행**
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}

}