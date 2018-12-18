/*
	쓰레드 동기화	synchronized
	쓰라는 위치에 예약어를 쓰기만 하면 쓰는건 된다.
		왜 쓰는가?
		어디에 정확히 쓰는가?
			다 줘도 에러는 안나.
			줘야 할 곳에 안주면 에러가 나지.
			run메서드에는 보통 거의 준다고 보면 됨.(항상)
			동시에 실행되는 작업이 있다 보니까.
	
	쓰레드 간 통신	notify()
		쓰레드 끝나고 나왔다고 다음 쓰레드에게 신호를 보냄
		쓰레드가 직접 하는게 아니라, 개발자가 적당한 위치에서 호출하게끔 위치를 잡아줘야 함.
		notifyAll() -> 전체 쓰레드를 다 깨운다(전체 쓰레드가 전부 경쟁을 하는 것), 대기하는 쓰레드가 많으면 이걸 쓰는게

		작업이 끝나고 나왔을 때 깨운다 -> 물 흐르듯이 흐름, InterruptedException 발생이 안함. 이해가 쉽다
		안에 들어간 쓰레드를 강제로 끌고 나온다 -> 운영체제가 스케쥴링 한 것을 끼어든 것, InterruptedException 발생함. wait()-> 자동으로 notify()를 부름

			cf)강제로 garvage collection 하는 메서드 들도 있다. Object 쪽도 쓸 만한게 있음.

	재고 관리 로직을 해볼 것
	빵을 몇 개를 만들어야 재고가 안남을까 - 10개라고 가정
	빵을 만듬 -동시- 빵이 팔림


충돌이 나는 경우는 아니지만 동기화를 해야 하는 경우

	계좌	10,000 원
 아들				엄마

한 명이 접속해 있는 경우엔 접속을 못하게 해야 함.
*/

class BreadPlate {// 공유하는 변수에 작업하는 메서드들을 묶어놓은 클래스 / 공유용
	private int cnt;	// 빵 개수
	
	public synchronized void sell(){	// 빵 --		// 빵이 0개면 임계영역에서 강제로 빼야 한다.	
		if( cnt > 0 ){
			cnt --;
			System.out.println("빵 판매 : " + cnt + "개 가 남아있다.");
			notifyAll();	// 운영체제가 스케쥴링하는거라 어떻게 될지는 모르지만..
		} else {
			System.out.println("빵이 모자란다!");
			try{
			wait();
			}catch(InterruptedException e){ 
				e.printStackTrace(); 
			}
		}
	}	// void sell()

	public synchronized void make(){	// 빵 ++		// 빵 재고가 10개를 넘어가징 ㅏㄶ게
		if( cnt < 10 ){
			cnt ++;
			System.out.println("빵 제작 : " + cnt + "개 가 남아있다.");
			notifyAll();
		} else {
			System.out.println("빵이 꽉 찾군!!");
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
	//생성자
	public BreadSeller ( BreadPlate bp ){
		this.bp = bp;	// 객체 초기화
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