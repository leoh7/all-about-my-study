import mypack.MyPackOne;
import mypack.MyPackTwo;
public class PackageEx {
	public static void main(String[] args) {
		MyPackOne mo = new MyPackOne();
		mo.one();
		MyPackTwo mt = new MyPackTwo();
		mt.two();
	}
}
