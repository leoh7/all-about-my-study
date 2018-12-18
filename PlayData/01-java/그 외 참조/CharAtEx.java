class CharAtEx {
	String isPalindrome(String string) {
		
		String isPalin = "true";
		
		int len = string.length();

		for( int i=0; i < len/2 ; i++){
			if(string.charAt(i) != string.charAt(len-i-1) ){
				isPalin = "false";
			}
		}
		return isPalin;
	}
	
	public static void main(String[] args) {
		CharAtEx ca = new CharAtEx();

		System.out.println(ca.isPalindrome("880731"));
	}
}
