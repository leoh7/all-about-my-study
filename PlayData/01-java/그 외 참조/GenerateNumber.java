//난수 생성
//안되네 근데

public static int GenerateNumber(int length) {
 
    String numStr = "1";
    String plusNumStr = "1";
 
    for (int i = 0; i < length; i++) {
        numStr += "0";
 
        if (i != length - 1) {
            plusNumStr += "0";
        }
    }
 
    Random random = new Random();
    int result = random.nextInt(Integer.parseInt(numStr)) + Integer.parseInt(plusNumStr);
 
    if (result > Integer.parseInt(numStr)) {
        result = result - Integer.parseInt(plusNumStr);
    }
 
    return result;
}
 


//출처: http://6developer.com/111 [망해도 다시한번]