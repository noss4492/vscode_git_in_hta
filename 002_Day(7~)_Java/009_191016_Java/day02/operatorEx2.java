package day02;

public class operatorEx2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		// int���� ���� �����ϸ� int ��ȯ, (byte + byte -> �ص� int�÷� �ȴ���)
		System.out.println(a+b);
		System.out.println("a--- "+(a+b));
		System.out.println("b--- "+(a%b));
		System.out.println("c--- "+(a/b));//�Ҽ������� ����
		System.out.println("dddd "+(a*b));
		// ���� : ctrl + alt + down (vscode ����Ű�� ã�ƺ� ��)
		
		byte c1 = 10;
		byte c2 = 17;
		System.out.println(c1+c2);
		
		// byte c3 = c1+c2; intŸ���̶� �� ���
		// System.out.println(c3);
	}

}
