public class MakeTimeClass {
	private int		hour;
	private int		minute;
	private	float	second;

	public int		getHour()		{ return hour;	 }
	public int		getMinute()		{ return minute; }
	public float	getSecond()		{ return second; }

	public void		setHour(int h)	{
		if(h < 0 || h > 23) return;
		hour = h;
	}
	public void		setMInute(int m){ 	
		if(m < 0 || m > 60) return;
		minute = m;
	}
	public void		setSecond(int s){
		if(s < 0.0f || s > 60.00f) return;
		second = s;
	}



	public static void main(String[] args) {
		
	}
}
