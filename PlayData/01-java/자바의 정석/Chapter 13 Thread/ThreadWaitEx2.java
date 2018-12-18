import java.util.ArrayList;

class Customer implements Runnable{
	private static Table table;
	private static String food;

	public Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}

	public void run(){
		while(true){
			try{
				Thread.sleep(10);
			}catch(InterruptedException ie){}
			String name = Thread.currentThread().getName();

			if( eatFood() )
				System.out.println(name+ " ate a " + food);
			else 
				System.out.println(name + " failed to eat. :(");
		}
	}

	boolean eatFood()	{ 
		return table.remove(food);
	}
}

class Cook implements Runnable{
// 멤버 변수	
	private Table table;

// 생성자
	public Cook(Table table){
		this.table = table;
	}
// 멤버 메서드 x run()	
	public void run(){
		while(true){
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try{
				Thread.sleep(100);
			}catch(InterruptedException ie){}
		}
	}
}

class Table {
	String[] dishNames = { "donut","donut","burger" };
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		if(dishes.size() >= MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes:"+dishes.toString());
	}

	public boolean remove(String dishName){
		synchronized(this){
			while(dishes.size()==0) {
				String name = Thread.currentThread().getName();
				System.out.println(name+ " is waiting.");
				try{
					Thread.sleep(500);
				}catch(InterruptedException ie){}
			}

			for(int i=0; i<dishes.size(); i++)
				if(dishName.equals(dishes.get(i))){
					dishes.remove(i);
					return true;
			}
		
		} // synchronized
		return false;
	}

	public int dishNum() {
		return dishNames.length;
	}
}

class ThreadWaitEx2 {
	public static void main(String[] args) throws Exception	{
		Table table = new Table(); // 여러 쓰레드가 공유하는 객체

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "buger"), "CUST2").start();

		Thread.sleep(1000 * 5);
		System.exit(0);
	}
}
