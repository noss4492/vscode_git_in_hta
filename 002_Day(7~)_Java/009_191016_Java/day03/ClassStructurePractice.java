package day03;
import java.io.IOException;

//statement Ex7�� Ȯ����.
public class ClassStructurePractice {
	static char stuGrade(int kor, int eng, int mat) {
		float sum = 0.0f;
		sum = kor + eng + mat;
		float avg = sum/3;
		
		if(avg >= 90) 
			return 'A'; 
		else if(avg >= 80) 
			return 'B'; 
		else if(avg >= 70) 
			return 'C'; 
		else if(avg >= 60)
			return 'D'; 
		else 
			return 'F';
	}
	
	static class StuReport{			// report table  
	// ����ƽ�� �� ������ �ʴ� Ŭ������ ��ü�������ε�? ��..
	// ��.. �̷� ������ ����Ǵ� �� ����. �̷��� ������ ���Ŀ� �����Ͽ��� �� �� �ϴ�.
		String name;
		int kor;
		int eng;
		int mat;
		char grade;
		StuReport(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
			this.grade = stuGrade(kor, eng, mat);
		}
	}

	public static void main(String[] args) {
		StuReport[] srt = {							// srt student report table
				new StuReport("Scott", 55, 90, 70),
				new StuReport("Blake", 95, 50,100),
				new StuReport("David", 99, 99, 99),
				new StuReport("Ralph", 30, 20, 40)
				};
		
		for(int i=0; i<srt.length; i++)
			System.out.println(srt[i].name+"�� ��� ������ "+srt[i].grade+" �Դϴ�.");
	}
}





/*
 * ��ü ���̺��� ������� �ϴ� �޼����� ��쿡�� �̷� ������ �ۼ��ϸ� �� ������ �����ȴ�.
static char stuGrade(StuReport[] dat){
	//float sum[] = {0.0f, 0.0f, 0.0f};
	float sum = 0.0f;
	
	for(int i = 0; i < dat.length; i++) {
		sum = dat[i].kor + dat[i].eng + dat[i].mat;
	}
*/

//static char stuGrade(StuReport[] dat){
//float sum[] = {0.0f, 0.0f, 0.0f};
//for(int i = 0; i < dat.length; i++) {
//	sum = dat[i].kor + dat[i].eng + dat[i].mat;
//}		
//}
