/*
ReentrantLock			�������� ������ lock. ���� �Ϲ����� ��Ÿ lock
ReentrantReadWriteLock	�б⿡�� �������̰�, ���⿡�� ��Ÿ���� lock
StampedLock				ReentrantReadWriteLock �� �������� lock�� ����� �߰�

ReentrantLock
	Ư�� ���ǿ��� lock �� Ǯ�� ���߿� �ٽ� lock �� ��� �Ӱ迵������ ���� �۾��� ������ �� ����
ReentrantReadWriteLock 
	�б⸦ ���� lock �� ���⸦ ���� lock �� ����. �б� lock �� �ɷ�������, �ٸ� �����尡
	�б� lock �� �ߺ��ؼ� �ɰ� �б⸦ ������ �� �ִ�.
	�׷��� �б� lock �� �ɸ� ���¿��� ���� lock �� �Ŵ� ���� ������ �ʴ´�. �ݴ뵵 ��������.
StampedLock 
	lock �� �ɰų� ������ �� '������(long Ÿ���� ������)'�� ���,
	�б�� ���⸦ ���� lock �ܿ� '������ �б� lock(optimistic reading lock)' �� �߰��� ��.
	������ �б� lock �� ���� lock �� ���� �ٷ� Ǯ����. �׷��� ������ �б⿡ �����ϸ� �б� lock �� �ٽ� �о� �;� ��.

	������ �б� lock �� ���� �ʰ�, ����� �бⰡ �浹�� ���� ���Ⱑ ���� �Ŀ� �б� lock�� �Ŵ� ���̴�.


*/

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Customer implements Runnable{
	private Table table;
	private String food;

	public Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}
	public void run(){
		while(true){
			try{ Thread.sleep(100); }catch(InterruptedException e){}
			String name = Thread.currentThread().getName();

			table.remove(food);
			System.out.println(name+" ate a "+food);
		}
	}
}

class ThreadWaitEx4 {
	public static void main(String[] args) {

	}
}
