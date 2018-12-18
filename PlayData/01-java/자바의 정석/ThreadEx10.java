// Daemon thread example
public class ThreadEx10 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());
		t.setDaemon(true); // **�� �κ��� ������ ������� �ʴ´�.**
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

		System.out.println("���α׷��� �����մϴ�.");
	}

	@Override
	public void run() {
		// **���󾲷��� ������ ���� ���ѷ��� ���� �� Ư�� ���� �϶� ����**
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
		System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
	}

}