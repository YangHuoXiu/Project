package dayone;
/**
 * 
 * 对于静态变量、静态初始化块、变量、初始化块、构造器，
 * 它们的初始化顺序以此是（静态变量、静态初始化块）
 * >（变量、初始化块）>构造器
 *
 */
public class DayoneTest {
	
	public String file="变量";
	public static String staticFiled="静态变量";
	
	{
		System.out.println(file);
		System.out.println("初始化块");
	}
	static{
		System.out.println(staticFiled);
		System.out.println("静态初始化快");
	}
	public DayoneTest()   //构造函数
	{
		System.out.println("构造器");
	}
	public static void main(String[] args)
	{
		new DayoneTest();
	}
}
