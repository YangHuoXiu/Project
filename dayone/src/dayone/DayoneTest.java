package dayone;
/**
 * 
 * ���ھ�̬��������̬��ʼ���顢��������ʼ���顢��������
 * ���ǵĳ�ʼ��˳���Դ��ǣ���̬��������̬��ʼ���飩
 * >����������ʼ���飩>������
 *
 */
public class DayoneTest {
	
	public String file="����";
	public static String staticFiled="��̬����";
	
	{
		System.out.println(file);
		System.out.println("��ʼ����");
	}
	static{
		System.out.println(staticFiled);
		System.out.println("��̬��ʼ����");
	}
	public DayoneTest()   //���캯��
	{
		System.out.println("������");
	}
	public static void main(String[] args)
	{
		new DayoneTest();
	}
}
