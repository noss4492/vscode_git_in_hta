package day02;
//���� ���� �켱 �ý��� ������ ���� ���
// ��... �ϵ����̺� CRC����ȣȭ ����� �ϵ���� �������� ���������� ����Ʈ ���
public class operatorEx3 {
	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println("wowo");
		byte b = 10;
		System.out.println((b>>2)+"�̰��� R����Ʈ 2"); //1010 >>2  : 0010
		System.out.println((b<<2)+"�̰��� L����Ʈ 2"); //1010 <<2  : 10 1000 
		
		System.out.println((b>>>2)+"�̰��� R����Ʈ 2"); //1010 >>2  : 0010
		// >>   : ���������� �а�, ���� �ڸ��� 0���� ä�� x
		// ã�ƺ��ϱ� ��ȣ�� ������� �ʰ� ����
		// >>>  : ���������� �а�, ���� �ڸ��� ��ȣ �ڸ��� ä��(��ȣ�����ε�)
	}
}
