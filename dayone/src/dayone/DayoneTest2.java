package dayone;
class Parent
{
	public static String p_StaticField="����--��̬����";
	public String p_Field="����--����";
	static 
	{
		System.out.println(p_StaticField);
		System.out.println("����--��̬��ʼ����");
	}
	{
		System.out.println(p_Field);
		System.out.println("����--��ʼ��");
	}
	public Parent()
	{
		System.out.println("����--������");
	}
}
public class DayoneTest2 extends Parent{
	public static String s_StaticField="����--��̬����";
	public String s_Field="����--����";
	static
	{
		System.out.println(s_StaticField);
		System.out.println("����--��̬��ʼ����");
	}
	{
		System.out.println(s_Field);
		System.out.println("�����ʼ����");
	}
	public DayoneTest2()
	{
		System.out.println("����--������");
	}
	public static void main(String[] args)
	{
		new DayoneTest2();
	}
	
	

}
