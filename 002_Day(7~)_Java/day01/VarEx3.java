package day01;

public class VarEx3 {
	public static void main(String[] args) {
		// byte  short int   long  
		// 1byte 2byte 4byte 8byte | 8bit 16bit 32bit 64bit
		//       char
		// US7ANCII KO16KSC5601 KO16MSWIN949 UNICODE
		byte b1 = 10;
		byte b2 = 50;
		System.out.printf("��½�b1:%d, %d \n", b1, b2);
		
		short sh1 = 10;
		//b1 = sh1;	
		// ���Կ�����s �����÷ο�s
		// ������~ ����ȯ~ ������~ �ս�~ ��~ ����~ ��~ ��~
		b1 = (byte)sh1;
		
		System.out.println(b1+"= b1");
		
		sh1 = 128;
		b1 = (byte)sh1;
		System.out.println(b1+"= b1");
		//1000 0000�� ���� -128��
		//0000 0000 1000 0000�� 128��
		//2�� ������ �����ؼ� ���� �����Ѱ� ��ŵ��, ���� ������ ã�ƺ����Ͻ�
		
		
		char c = 'a';
		char c2 = 97;
		char c3 = '\u0061';
		System.out.printf("%c %c %c\n\n",c,c2,c3);
	}
}
