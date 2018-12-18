/*
ReentrantLock			재진입이 가능한 lock. 가장 일반적인 배타 lock
ReentrantReadWriteLock	읽기에는 공유적이고, 쓰기에는 배타적인 lock
StampedLock				ReentrantReadWriteLock 에 낙관적인 lock의 기능을 추가

ReentrantLock
	특정 조건에서 lock 을 풀고 나중에 다시 lock 을 얻고 임계영역으로 들어와 작업을 수행할 수 있음
ReentrantReadWriteLock 
	읽기를 위한 lock 과 쓰기를 위한 lock 을 제공. 읽기 lock 이 걸려있으면, 다른 쓰레드가
	읽기 lock 을 중복해서 걸고 읽기를 수행할 수 있다.
	그러나 읽기 lock 이 걸린 상태에서 쓰기 lock 을 거는 것은 허용되지 않는다. 반대도 마찬가지.
StampedLock 
	lock 을 걸거나 해지할 때 '스탬프(long 타입의 정수값)'를 사용,
	읽기와 쓰기를 위한 lock 외에 '낙관적 읽기 lock(optimistic reading lock)' 이 추가된 것.
	낙관적 읽기 lock 은 쓰기 lock 에 의해 바로 풀린다. 그래서 낙관적 읽기에 실패하면 읽기 lock 을 다시 읽어 와야 함.

	무조건 읽기 lock 을 걸지 않고, 쓰기와 읽기가 충돌할 때만 쓰기가 끝난 후에 읽기 lock을 거는 것이다.


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
