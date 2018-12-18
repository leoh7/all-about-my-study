package wiring.bean;

public class Stage {
	private static Stage stage = new Stage();
	public static Stage getInstance() {			// factory method
		return stage;
	}
	public void message(){
		System.out.println("무대를 만들어 볼까여! : 팩토리 메서드입니다.");
	}
}