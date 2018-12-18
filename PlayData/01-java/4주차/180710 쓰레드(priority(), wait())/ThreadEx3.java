/*
	������ ����ȭ	synchronized
	����� ��ġ�� ���� ���⸸ �ϸ� ���°� �ȴ�.
		�� ���°�?
		��� ��Ȯ�� ���°�?
			�� �൵ ������ �ȳ�.
			��� �� ���� ���ָ� ������ ����.
			run�޼��忡�� ���� ���� �شٰ� ���� ��.(�׻�)
			���ÿ� ����Ǵ� �۾��� �ִ� ���ϱ�.
	
	������ �� ���	notify()
		������ ������ ���Դٰ� ���� �����忡�� ��ȣ�� ����
		�����尡 ���� �ϴ°� �ƴ϶�, �����ڰ� ������ ��ġ���� ȣ���ϰԲ� ��ġ�� ������ ��.
		notifyAll() -> ��ü �����带 �� �����(��ü �����尡 ���� ������ �ϴ� ��), ����ϴ� �����尡 ������ �̰� ���°�

		�۾��� ������ ������ �� ����� -> �� �帣���� �帧, InterruptedException �߻��� ����. ���ذ� ����
		�ȿ� �� �����带 ������ ���� ���´� -> �ü���� �����층 �� ���� ����� ��, InterruptedException �߻���. wait()-> �ڵ����� notify()�� �θ�

			cf)������ garvage collection �ϴ� �޼��� �鵵 �ִ�. Object �ʵ� �� ���Ѱ� ����.

	��� ���� ������ �غ� ��
	���� �� ���� ������ ��� �ȳ����� - 10����� ����
	���� ���� -����- ���� �ȸ�


�浹�� ���� ���� �ƴ����� ����ȭ�� �ؾ� �ϴ� ���

	����	10,000 ��
 �Ƶ�				����

�� ���� ������ �ִ� ��쿣 ������ ���ϰ� �ؾ� ��.
*/

class BreadPlate {// �����ϴ� ������ �۾��ϴ� �޼������ ������� Ŭ���� / ������
	private int cnt;	// �� ����
	
	public synchronized void sell(){	// �� --		// ���� 0���� �Ӱ迵������ ������ ���� �Ѵ�.	
		if( cnt > 0 ){
			cnt --;
			System.out.println("�� �Ǹ� : " + cnt + "�� �� �����ִ�.");
			notifyAll();	// �ü���� �����층�ϴ°Ŷ� ��� ������ ������..
		} else {
			System.out.println("���� ���ڶ���!");
			try{
			wait();
			}catch(InterruptedException e){ 
				e.printStackTrace(); 
			}
		}
	}	// void sell()

	public synchronized void make(){	// �� ++		// �� ��� 10���� �Ѿ¡ ������
		if( cnt < 10 ){
			cnt ++;
			System.out.println("�� ���� : " + cnt + "�� �� �����ִ�.");
			notifyAll();
		} else {
			System.out.println("���� �� ã��!!");
			try{
				wait();
			}catch(InterruptedException e){ 
				e.printStackTrace(); 
			}		
		}
	}	// void make()

}	// BreadPlate



/////////////////////////////////////////////////////////////////////
class BreadSeller extends Thread {
	private BreadPlate bp;
	//������
	public BreadSeller ( BreadPlate bp ){
		this.bp = bp;	// ��ü �ʱ�ȭ
	}
	public void run() {
		for(int i=0; i<10 ; i++){
			bp.sell();
		}
	}
}

class BreadMaker extends Thread {
	private BreadPlate bp;
	public BreadMaker ( BreadPlate bp ){
		this.bp = bp;
	}
	public void run() {
		for(int i=0; i<20 ; i++){
			bp.make();
		}
	}
}


class ThreadEx3 {
	public static void main(String[] args) {
		BreadPlate bp = new BreadPlate();
		BreadSeller bs = new BreadSeller( bp );
		BreadMaker bm = new BreadMaker( bp );
	
		bs.start();
		bm.start();
	}
}