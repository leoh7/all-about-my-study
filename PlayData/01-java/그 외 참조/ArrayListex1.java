import java.util.*;

public class ArrayListex1{ 
	
	List<Object> oPerlishArray = new ArrayList<Object>();

    // 배열 요소 몇 개 채우기, 문자열 숫자 가리지 않고
    oPerlishArray.add(123);
    oPerlishArray.add("하하하");

    // 이제는 배열 요소 (숫자) 한꺼번에 채우기
    for (int x = 10; x <= 100; x++) oPerlishArray.add(x);


    // 배열 출력
    for (int i = 0; i < oPerlishArray.size(); i++)
      System.out.format("[%d] = %s%n", i, oPerlishArray.get(i));

  }
}
