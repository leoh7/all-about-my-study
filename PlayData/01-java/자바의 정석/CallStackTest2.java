class CallStackTest2 {
	public static void main(String[] args) {
		System.out.println("1. main(String[] args) �� ���۵Ǿ���.");
		firstMethod();
		System.out.println("6.main(String[] args) �� ������.");
	}

	static void firstMethod() {
		System.out.println("2.firstMethod() �� ���۵Ǿ���.");
		secondMethod();
		System.out.println("5.firstMethod() �� ������.");
	}
	static void secondMethod() {
		System.out.println("3.secondMethod() �� ���۵Ǿ���.");
		System.out.println("4.secondMethod() �� ������.");
	}
}
