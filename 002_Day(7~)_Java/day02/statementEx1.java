package day02;
// main method
// ��� : �ݺ���

public class statementEx1 {
	public static void print_1to100(int n) {		// ����� �Լ��� �̷��� ����±�
		for(int j =1; j<n; j++) 
			System.out.printf("%3d",j);
	}
	
	public static void print_x5(int n) {
		for(int j=1; j<=n; j++)
			System.out.println(""+j+j+j+j+j);		// �������� ���� �ʰ�
	}
/*
	public static void m_table(int n, int m) {		//n x m������ ������ ���(��������)
		for (int i = 1; i<n; i++) {
			for( int j = 1; j<m; j++) {
				System.out.printf(i+"*"+j+":%2d  ", i*j);
			}
			System.out.println();
		}
	}
*/
	public static void m_table2(int n, int m) {		//n x m������ ������ ���(��������)
		for (int j = 1; j<n; j++) {
			for( int i = 1; i<m; i++) {
				System.out.printf(j+"*"+i+":%2d  ", i*j);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		statementEx1.print_1to100(100);		
		statementEx1.print_x5(5);
		System.out.println();
		//statementEx1.m_table(10, 10);
		statementEx1.m_table2(10, 10);
		
	}// method end
}///////////////// class end
