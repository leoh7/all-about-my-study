import java.util.*;

public class ArrayListex1{ 
	
	List<Object> oPerlishArray = new ArrayList<Object>();

    // �迭 ��� �� �� ä���, ���ڿ� ���� ������ �ʰ�
    oPerlishArray.add(123);
    oPerlishArray.add("������");

    // ������ �迭 ��� (����) �Ѳ����� ä���
    for (int x = 10; x <= 100; x++) oPerlishArray.add(x);


    // �迭 ���
    for (int i = 0; i < oPerlishArray.size(); i++)
      System.out.format("[%d] = %s%n", i, oPerlishArray.get(i));

  }
}
