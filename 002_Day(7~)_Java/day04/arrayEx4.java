package day04;

public class arrayEx4 {
	// �Ϲ����� ������Ƽ�� Ÿ���� ������ ���ÿ� �Ҵ��.
	// ���۷��� Ÿ���� ������ ���� �Ҵ��(�����Ҵ�ö�� �˰� �־��µ� ��)
	// *���� �Ҵ�� �ּҸ� ������ ����(int type)�� ������ ����.
	// *���ÿ��� �Ҵ�� ���۷��� Ÿ���� ������ ����  �ּ�(������)�� ������ ����
	
	// primitive type : 8�� ��
	// reference type : array, ....
	
	// [4][4] �迭�̶� �����ϰ� [0][3]�ڿ� ���� �޸� �ּҴ� [1][0]�� ���ӵ��� ���� �� ����.
	// �ʱ�ȭ�� {1,2,3,4,} �̷� ������ �߰� ��ǥ�� 

	public static void main(String[] args) {
		int [] m;
		// �ڷ���[] ������;
		// �ڷ��� ������ [];
		
		//������ Ȯ��. ���ÿ��� �Ҵ�� m�� �������� �Ҵ�� ���۷���Ÿ�� ������ �ּ�(������)�� ������ �ִ�.
		System.out.println("------ù��°, �迭�� �����ϰ� �ִ� �������� Ȯ��------");
		m = new int[3];
		for(int i=0; i<3; i++)
			System.out.println(m);	
		
		System.out.println("------�ι�°------");
		int[] mm = {5, 10, 15, 20, 25};
		for(int i=0; i<5; i++) {
			System.out.println(mm[i]);
		}
		//System.out.println("���ÿ��� �����ϰ� �ִ� �ּ�(������) :"+mm);
		
		System.out.println("------����°------");
		int[] c;
		c = new int[5];
		for(int i=0; i<c.length; i++) {
			c[i] = (i+1)*5;
			System.out.println("c["+i+"] : "+c[i]);	
		}
		///////////////////////////////////////////////////////
		System.out.println("------����°(Ȯ��for��)------");
		for(int i : mm)
			System.out.println(i);
		///////////////////////////////////////////////////////
		System.out.println("------�׹�°------");
		int[] cc = {1,3,5,7,9,11,13};
		for(int ixi : cc)				// Ȯ�� for�� ���
			System.out.print(ixi+"\t");
		System.out.println("||");
		
										// �ʱⰪ ����
		for(int i = 0; i < cc.length; i++)
			System.out.print(cc[i]+"\t");
		System.out.println("||");
		
		
		int [] dd = new int[7];		// for������ �迭�� �����Ͽ� ä��
		for(int i=0; i<dd.length; i++) {
			dd[i] = 1+i*2;
			System.out.print(dd[i]+"\t");
		}
		System.out.println("||");
		///////////////////////////////////////////////////////
		//int[] ed;						
		//ed = new int[7];
		//int [] = new int[7]; ���� �ٿ� �� �� �̽�
	}
}
